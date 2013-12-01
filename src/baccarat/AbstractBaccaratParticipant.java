package baccarat;

import java.util.ArrayList;

import utilities.LastDigit;
import cards.Card;
import cards.Deck;

public abstract class AbstractBaccaratParticipant implements BaccaratParticipant {
	
	private State state = State.none;
	private Card lastDraw = null;
	Deck deck;
	public AbstractBaccaratParticipant(Deck deck) {
		this.deck = deck;
		
	}

	@Override
	public State getState(){
		return state;
	}
	
	@Override
	public void setState(State state){
		this.state = state;
	}
	

	ArrayList<Card> hand = new ArrayList<>();
	
	@Override
	public int getHandValue() {		
		int total = 0;
		
		// foreach loop
		for(Card card : hand ){
			total += card.getValue();
		}
		
		return LastDigit.stripLastDigit(total);
	}
	
	@Override
	public void getFirstHand(){
		getNextCard();
		getNextCard();	
	}
	
	@Override
	public void getNextCard() {
		Card card = deck.getNextCard(); 
		System.out.println(this + " got " + card + " " + card.getValue());
		hand.add(card);		
	}
	
	public void clearHand(){
		hand.clear();
		
	}

	@Override
	public Card getLastDraw(){
		return this.lastDraw;
	}
	
}