package baccarat;

import java.util.ArrayList;

import utilities.LastDigit;
import cards.Card;

public abstract class AbstractBaccaratParticipant implements BaccaratParticipant {

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
	
	
	
}