package baccarat;

import static baccarat.State.drew;
import static baccarat.State.stood_pat;
import cards.Card;

public class BaccaratGame {
	
	private final Player player;
	private final Banker banker;
	
	
	public BaccaratGame(Player player, Banker banker) {
		this.banker = banker;
		this.player = player;
	}
	
	public void startGame(){
		
		BaccaratParticipant[] winners = null;

		while(winners == null){
			// 1. Check if it's a natural
			if(checkIfNatural()){
				winners = getWinners();
			}
			
			consultTableu(player, 6);
			
			if(player.getState() == stood_pat){
				consultTableu(banker, 6);
			} else {
				consulTableuParticipantStoodPat(banker);
			}
					

		}
		
		
		System.out.println("The winners are: "+ winners);
		
	}
	
	


	private boolean checkIfNatural(){
		if(banker.getHandValue() >= 8 || banker.getHandValue() >= 8 ){
			return true;
		}
		
		return false;
	}
	
	private BaccaratParticipant[] getWinners(){
		if(banker.getHandValue() > player.getHandValue()){
			return new BaccaratParticipant[]{ banker };
		} else if( banker.getHandValue() == player.getHandValue()){
			return new BaccaratParticipant[]{ banker, player };
		}
		
		return new BaccaratParticipant[]{ player };
	}
	
	/**
	 * @return true if participant should draw a third card
	 */
	private void consultTableu(BaccaratParticipant participant, int threshold){		
		//If Player has an initial total of 0–5, he draws a third card. 
		//If Player has an initial total of 6 or 7, he stands.
		if(player.getHandValue() < threshold ){
			participant.getNextHand();
			participant.setState(drew);
		}
		
		participant.setState(stood_pat);
		
	}	
	
	private void consulTableuParticipantStoodPat(Banker banker) {
		Card lastDraw = player.getLastDraw();
		
		if(lastDraw.getValue() < 4){
			consultTableu(banker, 4);
		} else if (lastDraw.getValue() < 6){
			consultTableu(banker, 6);
		} else if (lastDraw.getValue() < 7){
			consultTableu(banker, 7);
		}
		
	}
	

}
