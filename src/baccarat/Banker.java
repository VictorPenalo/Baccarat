package baccarat;

import cards.Deck;

public class Banker extends AbstractBaccaratParticipant {
	public Banker(Deck deck){
		super(deck);		
	}
	
	@Override
	public String toString() {	
		return "Banker";
	}
}