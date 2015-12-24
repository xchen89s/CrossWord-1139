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
		String res = getStringRestrictions(gb, firstPosition, 0);
		String w = randomWord(res, 7);
		curWord.next = new WordList(w, firstPosition, 0);
		curWord = curWord.next;
		addWord(gb, w, firstPosition, curWord.getDirection());
		
		//TODO implement isFull and use while loop to generate wordlist.
		/*
		//while (gb.isFull()) {
			//TODO need to deal with backtracking cases
			Position nextPosition = rdmPosition(curWord);
			if (nextPosition!=null) {
				String restrictions = getStringRestrictions(gb, nextPosition, (curWord.getDirection()^1));
				int len = 0;
				//last is horizontal, next will be vertical. then use x to cal
				if (curWord.getDirection()==0) len = rdmlen(x-nextPosition.getX());
				else len = rdmlen(x-nextPosition.getY());
				String word = randomWord(restrictions, len);
				curWord.next = new WordList(word, nextPosition, (curWord.getDirection()^1));
				curWord = curWord.next;
			}
			else {
				//reach the bottom of the board. need to start from top again to squzze in more words
			}
		//}
		*/
			//TODO all numbers should be random
			Position nextPosition = new Position(0,3);//rdmPosition needs to be done
			String word = randomWord(" ", 6);		  //ramdomWord needs to be done
			curWord.next = new WordList(word, nextPosition, curWord.getDirection()^1);
			curWord = curWord.next;
			addWord(gb, word, nextPosition, curWord.getDirection());
			
			nextPosition = new Position(2, 3);
			word = randomWord("N      ", 4);
			curWord.next = new WordList(word, nextPosition, curWord.getDirection()^1);
			curWord = curWord.next;
			addWord(gb, word, nextPosition, curWord.getDirection());
			
			nextPosition = new Position(2, 6);
			word = randomWord("T     ", 5);
			curWord.next = new WordList(word, nextPosition, curWord.getDirection()^1);
			curWord = curWord.next;
			addWord(gb, word, nextPosition, curWord.getDirection());
			
			nextPosition = new Position(4,3);
			word = randomWord("  A ", 4);
			Position tmp = new Position(nextPosition.getX(), nextPosition.getY()-2);
			curWord.next = new WordList(word, tmp, curWord.getDirection()^1);
			curWord = curWord.next;
			addWord(gb, word, tmp, curWord.getDirection());
			
			nextPosition = new Position(4,1);
			word = "FOOL";
			curWord.next = new WordList(word, nextPosition, curWord.getDirection()^1);
			curWord = curWord.next;
			addWord(gb, word, nextPosition, curWord.getDirection());
			
			nextPosition = new Position(6,6);
			word = randomWord("CONTRACT", 9);
			tmp = new Position(nextPosition.getX(), nextPosition.getY()-6);
			curWord.next = new WordList(word, tmp, curWord.getDirection()^1);
			curWord = curWord.next;
			addWord(gb, word, tmp, curWord.getDirection());
			
		//print out the word list for now.
		//TODO UI design based on the list
		printLayout(gb);
	}
	
	public String randomWord(String restrictions, int length) {
		//search the dictionary and return the first word that meets the criteria
		if (length==7) return "STUDENT";
		else if (length==9) return "CONTRACTS";
		else if (length==6) return "DENTAL";
		else if (length==5) return "TOXIC";
		
		else if (length==4 && restrictions == "N      ") return "NEXT";
		else if (length==4) return "FLAG";
		return null;
	}

	public Position rdmPosition(WordList word) {
		if (word == null) return new Position(0, 0);
		int x=0, y=0;
		Random rm = new Random();
		//vertical
		if (word.getDirection()==1) {
			y = word.getPosition().getY();
			x = rm.nextInt(word.getWord().length())-word.getPosition().getX();
			return new Position(x, y);
		}
		//horizontal
		else {
			x = word.getPosition().getX();
			y = rm.nextInt(word.getWord().length())-word.getPosition().getY();
			return new Position(x, y);
		}
	}
	
	public int rdmlen(int max) {
		Random rm = new Random();
		return rm.nextInt(max);
	}
	
	public String getStringRestrictions(GameBoard gb, Position p, int direction) {
		//return a string to indicate any existing chars.
		//"s  t  "
		StringBuffer ans = new StringBuffer();
		if (direction == 0) {
			//horizontal
			char[] row = gb.getRow(p.getX());
			for (int i=p.getY();i<row.length;i++) ans.append(row[i]);
		}
		else {
			//vertical
			char[] col = gb.getCol(p.getY());
			for (int i=p.getX();i<col.length;i++) ans.append(col[i]);
		}
		return ans.toString();
	}
	
	public void addWord(GameBoard gb, String word, Position p, int d) {
		int row = p.getX(), col = p.getY();
		if (d==1) {
			for (int i=0;i<word.length();i++) {
				gb.setEntry(row, col, word.charAt(i));
				row++;
			}
		}
		else {
			for (int i=0;i<word.length();i++) {
				gb.setEntry(row, col, word.charAt(i));
				col++;
			}
		}
	}
	
	public void printLayout(GameBoard gb) {
		//to return the result
		
		for (int i=0;i<gb.size();i++) {
			for (int j=0;j<gb.size();j++) {
				System.out.print("|"+gb.getEntry(i,j));
			}
			
			System.out.print("\n");
		}
	}
}
