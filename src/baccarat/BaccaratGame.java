package baccarat;

import static baccarat.State.drew;
import static baccarat.State.stood_pat;

import java.util.ArrayList;

import cards.Card;
import cards.Deck;

public class BaccaratGame {
	
	private final Player player;
	private final Banker banker;
	
	public BaccaratGame() {		
		Deck deck = new Deck();
		
		this.banker = new Banker(deck);
		this.player = new Player(deck);
	}
	
	public ArrayList<Card>[] startGame(){
		
		player.clearHand();
		banker.clearHand();
		
		player.getFirstHand();
		banker.getFirstHand();
		
		return new ArrayList[]{player.getHand(), banker.getHand()};		
	}
	
	public void continueGame(){				

		// 1. Check if it's a natural
		if(checkIfNatural()){
			winLogic();
			return;
		}

		// If Player has an initial total of 0–5, he draws a third card. 
		// If Player has an initial total of 6 or 7, he stands.
		consultTableu(player, 6);

		// If Player stood pat (i.e., has only two cards), 
		// the banker regards only his own hand and acts 
		// according to the same rule as Player.
		if(player.getState() == stood_pat){
			consultTableu(banker, 6);
		} 

		//  If Player drew a third card, the Banker acts 
		//	according to the following more complex rules
		else if (player.getState() == drew) {
			consulTableuPlayerStoodPat(banker);
		}

		winLogic();

	}
	
	private void winLogic(){
		
		ArrayList<BaccaratParticipant> winners = null;

		winners = getWinners();
		
		if(winners.contains(player) && !winners.contains(banker) ){
			player.executeBetWon(true);
		} else if (!winners.contains(banker)){
			player.executeBetWon(false);
		}

		System.out.println("\nThe winners are: ");
		for(BaccaratParticipant p : winners)
			System.out.println(p);
		
		System.out.println("\n");
		
		player.clearHand();
		banker.clearHand();		
		
	}
	
	
	private boolean checkIfNatural(){
		if(banker.getHandValue() >= 8 || player.getHandValue() >= 8 ){
			return true;
		}
		
		return false;
	}
	
	/**
	 * @return The participant with the highest valued had, or both if it's a tie
	 */
	private ArrayList<BaccaratParticipant> getWinners(){
		ArrayList<BaccaratParticipant> winners = new ArrayList<BaccaratParticipant>();
		
		if(banker.getHandValue() > player.getHandValue()){
			winners.add( banker );
		} else if( banker.getHandValue() == player.getHandValue()){
			winners.add(banker);
			winners.add(player);
		} else {		
			winners.add(player);
		}
		
		return winners;
	}
	
	/**
	 * @return true if participant should draw a third card
	 */
	private void consultTableu(BaccaratParticipant participant, int threshold){	
		// Threshold cannot be 8 or 9 here, because that's a natural
		assert(threshold < 8);
		
		if(participant.getHandValue() < threshold ){
			participant.getNextCard();
			participant.setState(drew);
		}
		
		participant.setState(stood_pat);		
	}	
	
	private void consulTableuPlayerStoodPat(Banker banker) {
		// Lets see what the player drew
		int playersLastDraw = player.getLastDraw().getValue();
		
		// - If Player drew an ace, 9, 10, or face-card, the Banker 
		// draws with 0–3, and stands with 4–7.
		if( playersLastDraw <= 1 || playersLastDraw == 9 ){
			consultTableu(banker, 4);
		}
		//- If Player drew a 2 or 3, Banker draws with 0–4, and stands with 5–7.		
		else if(playersLastDraw < 4){
			consultTableu(banker, 5);
		}
		// - If Player drew a 4 or 5, Banker draws with 0–5, and stands with 6–7.
		else if (playersLastDraw < 6){			
			consultTableu(banker, 6);
		}
		// - If Player drew a 6 or 7, Banker draws with 0–6, and stands with 7.
		else if (playersLastDraw < 8){
			consultTableu(banker, 7);
		}
		//- If Player drew an 8, Banker draws with 0–2, and stands with 3–7.
		else if (playersLastDraw == 8){
			consultTableu(banker, 3);
		} 
	
	}	
	
}