package baccarat;

import cards.Deck;

public class Player extends AbstractBaccaratParticipant {
	private int purseValue = 50;
	private int betAmount = 1;
	
	
	public Player(Deck deck){
		super(deck);		
	}
	
	public void placeBet(int bet){
		assert( bet <= 5 && bet >=1);
		betAmount = bet;
		System.out.println("Player betAmount set to "+ betAmount);
	}
	
	public void executeBetWon(boolean won){
		if(won){
			purseValue += betAmount;
		} else {
			purseValue -= betAmount;
		}
	}
	
	public int getPurseValue(){
		return purseValue;
	}
	
	public int getBetAmount(){
		return betAmount;
	}
	
	@Override
	public String toString() {	
		return "Player";
	}	
}
