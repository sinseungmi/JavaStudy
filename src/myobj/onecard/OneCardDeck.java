package myobj.onecard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class OneCardDeck {
	
	ArrayList<Card> cards;
	ArrayList<Card> table;  //바닥에 놓여진 카드들 보관
	
	
	public OneCardDeck() {
		cards = new ArrayList<>();
		table = new ArrayList<>();
		
		//하트 칼라 조커, 스페이드 흑백 조커만 add하기
		for (Character suit : Card.SUITS) {
			for (String rank : Card.RANKS) {
				if (suit.equals('◇') && rank.equals("JOKER")) {
					continue;
				} else if(suit.equals('♣') && rank.equals("JOKER")) {
					continue;
				}else if (rank.equals("A")){ //공격카드 한장을 만드는 과정들
					Card card = new Card(suit, rank);
					card.setAttack(true);  //공격 카드니까 트루
					card.setAttackValue(3);  //공격 지수 셋팅
					cards.add(card);
				}else if(rank.equals("2")){
					Card card = new Card(suit, rank);
					card.setAttack(true);
					card.setAttackValue(2);
					cards.add(card);
				}else if(suit.equals('♡') && rank.equals("JOKER")){
					Card card = new Card(suit, rank);
					card.setAttack(true);
					card.setAttackValue(9);
					cards.add(card);
				}else if(suit.equals('♠') && rank.equals("JOKER")){
					Card card = new Card(suit, rank);
					card.setAttack(true);
					card.setAttackValue(7);
					cards.add(card);
				}else if(rank.equals("J") || rank.equals("Q") || rank.equals("K") ||
						rank.equals("7")){
					Card card = new Card(suit, rank);
					card.setSpecial(true);
					cards.add(card);
				}else {
					cards.add(new Card(suit, rank));
				}	
			}
		}
		
		shuffle();
		
	}	
	public Card tableCard() {
		if (table.size() == 0) {
			table.add(cards.remove(0));
		}
		
		return table.get(table.size() - 1);  
		//-1하는 이유는 index때문에..^^ 정신차리자~
	}
	public boolean submitCard(Card card) {
		Card tc = tableCard();
		
		boolean valid = false;
		
		if (tc.getRank().equals("JOKER")) {
			System.out.println("조커는 뒤에는 무조건 추가됨(공격이 빠졌을 시)");
			table.add(card);
			valid = true;
		}else if(card.getRank().equals("JOKER")) {
			System.out.println("조커는 무조건 추가됨");
			table.add(card);
			valid = true;
		}else if(tc.getRank().equals(card.getRank())) {
			System.out.println("숫자가 맞아서 추가됨");
			table.add(card);
			valid = true;
		}else if(tc.getSuit().equals(card.getSuit())) {
			System.out.println("문양이 맞아서 추가됨");
			table.add(card);
			valid = true;
		}
		
		if(valid && card.isAttack()) {
			//공격카드에 대한 처리
			System.out.println("방금 내신 카드는 공격 카드입니다");
			return true;
		}else if (valid && card.isSpecial()) {
			//스페셜 카드에 대한 처리
			System.out.println("방금 내신 카드는 스페셜 카드입니다");
			return true;
		}
		
		return false;
	}
	
	public void shuffle() {
		Collections.shuffle(cards); //카드 섞어버리기
		
	}
	
	public Card draw() { //뽑는다
		if(cards.size() == 0) {
						//-1하는 이유는 마지막 남은 한장을 남기기 위해서.
						//안남기고 다 섞으면 안되지!
			for (int i = 0, len = table.size() - 1; i < len; ++i) {
				cards.add(table.remove(0));
			}	
			shuffle();
			System.out.println("카드가 부족해서 테이블의 카드를 가져옴");
		}
		return cards.remove(0);  //리무브는 삭제하고 반환
	}
}











