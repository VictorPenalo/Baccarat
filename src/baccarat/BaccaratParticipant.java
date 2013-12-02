package baccarat;

import java.util.ArrayList;

import cards.Card;

public interface BaccaratParticipant {
	
	ArrayList<Card> getHand();
	
	int getHandValue();	
	/**
	 * Get the first hand, which is two cards.
	 */
	void getFirstHand();
	
	/**
	 * Gets the next card from the deck.
	 */
	void getNextCard();
	public State getState();
	void setState(State drew);
	Card getLastDraw();
	void clearHand();
}