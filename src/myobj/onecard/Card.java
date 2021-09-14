package myobj.onecard;

import java.util.HashSet;

public class Card {
	
	public static HashSet<Character> SUITS;
	public static HashSet<String> RANKS;
	
	static {
		
		SUITS = new HashSet<>();
		RANKS = new HashSet<>();
		
		SUITS.add('♣');
		SUITS.add('♠');
		SUITS.add('◇');
		SUITS.add('♡');
		RANKS.add("A");
		RANKS.add("2");
		RANKS.add("3");
		RANKS.add("4");
		RANKS.add("5");
		RANKS.add("6");
		RANKS.add("7");
		RANKS.add("8");
		RANKS.add("9");
		RANKS.add("10");
		RANKS.add("J");
		RANKS.add("Q");
		RANKS.add("K");
		RANKS.add("JOKER");
	}
	
	private Character suit;
	private String rank;
	private boolean isAttack; 
	private boolean isSpecial; 
	private int attackValue;
	
	//카드 한장을 만들고 꺼내오고 셋팅하고 하는 과정들.
	//카드 클래스는 카드 하나를 찍어내는 과정이다.
	public Card(Character suit, String rank){   
		this.suit = suit;
		this.rank = rank;
	}
	
	public boolean isSpecial() {
		return isSpecial;
	}

	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}

	public Character getSuit() {
		return suit;
	}

	public void setSuit(Character suit) {
		this.suit = suit;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public boolean isAttack() {
		return isAttack;
	}

	public void setAttack(boolean isAttack) {
		this.isAttack = isAttack;
	}

	public int getAttackValue() {
		return attackValue;
	}

	public void setAttackValue(int attackValue) {
		this.attackValue = attackValue;
	}
	@Override
	public String toString() {
		return String.format("[%c%s]", this.suit, this.rank);
	}
	
	

}
