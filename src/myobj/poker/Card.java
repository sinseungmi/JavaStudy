package myobj.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Card {
	int[] keep;
	final char[] num;
	int numOfPlayer;
	ArrayList<Character> spade,heart,diamond,club;
	ArrayList<List> card_list;
	Random ran;
	
	public Card() {
		this.ran = new Random();
		this.spade = new ArrayList<>();
		this.heart = new ArrayList<>();
		this.diamond = new ArrayList<>();
		this.club = new ArrayList<>();
		this.card_list = new ArrayList<>();
		
		this.num = new char[] {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
		
		for(int i = 0; i < num.length; i++) {
			spade.add(num[i]);   //shape에 카드 숫자 넣기
		}
		heart.addAll(spade);
		diamond.addAll(spade);
		club.addAll(spade);
		
		card_list.add(spade);card_list.add(heart);  //카드리스트에 shape들 저장
		card_list.add(diamond);card_list.add(club);
		
	}
	
	public void randomCard() {
		keep = new int[5];
		for (int i = 0; i < 5; i++) {
			keep[i] = ran.nextInt(card_list.size());
		}
		card_list.get(keep[1]);
		
		
	}
	public static void main(String[] args) {
		Card c = new Card();
		c.randomCard();
		
	}
	

}
