package baccarat;

import cards.Card;

public interface BaccaratParticipant {
	int getHandValue();
	void getNextHand();
	public State getState();
	void setState(State drew);
	Card getLastDraw();
}