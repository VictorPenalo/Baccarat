package cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {
	Random r = new Random( );
	Card[] deck = Card.values();
	ArrayList<Card> shuffledDeck = new ArrayList<Card>();

	private void shuffle( ){
		for (int i = 0; i < 100; i++) {
			int ran = r.nextInt( deck.length-1);
			int ran2 = r.nextInt( deck.length-1);	
			
			Card card1 = deck[ ran ];
			Card card2 = deck[ ran2 ];
			deck[ran2] = card1;
			deck[ran] = card2;
			
		}			
		
		shuffledDeck = new ArrayList<Card>(Arrays.asList(deck));
	}
	
	public Card getNextCard(){				
		if( shuffledDeck.isEmpty() ){
			shuffle();
		}
		
		return shuffledDeck.remove(0);
	}
}
