package examples;

import static utilities.LastDigit.stripLastDigit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import baccarat.BaccaratGame;
import utilities.LastDigit;


public class Example implements ActionListener {	
	
	public static void main(String[] args){
		
		BaccaratGame game = new BaccaratGame();
		
		for (int i = 0; i < 5; i++) {
			game.startGame();
		}

		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("WHATEVER");		
	}

}
