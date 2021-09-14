package myobj.poker;

import java.util.ArrayList;

public class Dealer {
	
	ArrayList<PokerCard> table;
	Deck deck;
	
	public Dealer(Deck deck) {
		table = new ArrayList<>();
		this.deck = deck;
	}
	public void next() {
		table.add(deck.draw());
	}

}
