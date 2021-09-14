package myobj.poker;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Deck {
	
	LinkedList<PokerCard> deck;
	
	public Deck() {
		deck = new LinkedList<>();
		
		for(Suit suit : PokerCard.SUITS) {
			for(Rank rank : PokerCard.RANKS) {
				deck.add(new PokerCard(rank,suit));
			}
		}
		Collections.shuffle(deck); //섞기
		
	}

	public PokerCard draw() {
		return deck.pop(); //pop(),poll() : List에서 맨앞에 데이터를 읽고 버린다
	}
	
	@Override
	public String toString() {
		return deck.toString();    //LinkedList안에 있는 내용을 문자열로 출력
	}
	
	public static void main(String[] args) {
		Deck d1 = new Deck();
		System.out.println(d1);
		
		//7장 뽑아보기
		System.out.println(d1.draw());
		System.out.println(d1.draw());
		System.out.println(d1.draw());
		System.out.println(d1.draw());
		System.out.println(d1.draw());
		System.out.println(d1.draw());
		System.out.println(d1.draw());
		
		System.out.println(d1);
	}
	

}






























