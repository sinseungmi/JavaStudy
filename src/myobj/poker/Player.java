package myobj.poker;

import java.util.ArrayList;

public class Player {
	
	ArrayList<PokerCard> hand;
	Deck deck;
	int money;
	
	public Player(Deck deck) {
		hand = new ArrayList<>();
		this.deck = deck;
	}
	
	public void firstDraw() {
		hand.add(deck.draw());
		hand.add(deck.draw());
	}
	
	public void peek() {
		System.out.println(hand);
	}
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		
		Player p1 = new Player(deck);
		Player p2 = new Player(deck);
		
		p1.firstDraw();
		p2.firstDraw();
		
		p1.peek();
		p2.peek();
	}

}
