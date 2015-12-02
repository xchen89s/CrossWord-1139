package View;

import Control.controls;

public class Game {
	controls controller;
	public Game() {
		//gb = new GameBoard(x);
		controller = new controls();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size=10;
		Game game = new Game();
		game.controller.intialize(size);
	}
}
