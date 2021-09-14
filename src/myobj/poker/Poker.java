package myobj.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class Poker {
	
	ArrayList<Player> players;
	
	Dealer dealer;
	Deck deck;
	
	public Poker() {
		players = new ArrayList<>();
		deck = new Deck();
		dealer = new Dealer(deck);
	}
	public void addPlayer() {
		players.add(new Player(deck));
	}
	public void start() {
		for (Player p : players) {
			p.firstDraw();
			p.peek();
		}
		
	}
	public void next() {
		dealer.next();
		System.out.println(dealer.table);
	}
	
	public void peekTable() {
		System.out.println(dealer.table);
	}
	
	public void open() {
		System.out.println("테이블에 깔린 카드: " + dealer.table);

		for(Player p : players) {
			HashSet<PokerCard> hand = new HashSet<>(dealer.table);
			System.out.println("사용자가 들고 있는 카드 : " + p.hand);
			
			hand.addAll(p.hand);
			
			check(hand);
		}
	}
	private int[] countSuits(HashSet<PokerCard> hand) {
	
		return null;
	}
	
	private int checkStraight(HashSet<PokerCard> hand) {
		
		ArrayList<PokerCard> sorted_hand = new ArrayList<>(hand);
		
		Collections.sort(sorted_hand);
		
		System.out.println("정렬된 핸드 : " + sorted_hand);
		
		for (int i = 2; i > -1; --i) {
			boolean straight = false;
			
			PokerCard card0 = sorted_hand.get(i);
			
			System.out.printf("스트레이트 체크%d: %s\n", 3 - i,sorted_hand.get(i));
			
			for(int j = 1; j < 5; ++j) {
				
				if(card0.getRankValue() + j == sorted_hand.get(i + j).getRankValue()) {
					
					straight = true;
				}else {
					straight = false;
					break;
					
				}
			}
			
			if (straight) {
				System.out.println(card0 + "로 시작하는 스트레이트");
				break;
			}
		}
		
		return 0;
	}
	
	//넘어온 hand 내부의 카드 7장으로 어떤 족보인지 맞추고 승패를 가릴 수 있는 점수를 리턴
	private int check(HashSet<PokerCard> hand) {
		HashSet<Rank> ranks = makeRankSet(hand);
		
		int straight = checkStraight(hand);
		
		return 0;
	}
	public HashSet<Rank> makeRankSet(HashSet<PokerCard> hand){
		HashSet<Rank> ranks = new HashSet<>();
		
		for(PokerCard card : hand) {
			ranks.add(card.rank);
		}
		
		return ranks;
	}
	
	public static void main(String[] args) {
		Poker game = new Poker();
		
		game.addPlayer();
		game.addPlayer();
		game.addPlayer();
		
		game.start();
		
		//베팅이 끝나면 딜러가 3장 공개
		game.next();
		game.next();
		game.next();
		
		//다음 베팅이 끝나면 딜러가 1장 공개
		game.next();
		//다음 베팅이 끝나면 딜러가 1장 공개
		game.next();
		
		game.peekTable();
		
		game.open();
	}

}
