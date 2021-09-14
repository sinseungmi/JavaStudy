package myobj.onecard;

public class OneCard {
	
	OneCardDeck deck;
	
	public OneCard() {
		deck = new OneCardDeck();
		
		for (int i = 0; i < 100; i++) {
			Card c = deck.draw();
			deck.submitCard(c);
			
			
			System.out.println("------------------------");
			System.out.println("방금 낸 카드 : " + c);
			System.out.println("테이블에 보여지는 카드: "+ deck.tableCard());
			System.out.println("현재 테이블 상태: " + deck.table);
			System.out.println("현재 카드더미 상태: " + deck.cards);
		}
	}
	public static void main(String[] args) {
		new OneCard();
	}

}
