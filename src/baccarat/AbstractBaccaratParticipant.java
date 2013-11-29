package baccarat;

import java.util.ArrayList;

import utilities.LastDigit;
import cards.Card;

public abstract class AbstractBaccaratParticipant implements BaccaratParticipant {
	
	private State state = State.none;
	private Card lastDraw = null;
	
	@Override
	public State getState(){
		return state;
	}
	
	@Override
	public void setState(State state){
		this.state = state;
	}
	

	ArrayList<Card> cards = new ArrayList<>();
	
	@Override
	public int getHandValue() {		
		int total = 0;
		
		// foreach loop
		for(Card card : cards ){
			total += card.getValue();
		}
		
		return LastDigit.stripLastDigit(total);
	}
	
	@Override
	public void getNextHand() {
		// Assign lastDraw in here
	}
	
	@Override
	public Card getLastDraw(){
		return this.lastDraw;
	}
	
}