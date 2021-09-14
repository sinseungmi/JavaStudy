package swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class S07_CardLayout extends MyFrame{
	
	/*
	 * # CardLayout
	 * 
	 * -컴포넌트를 카드처럼 넘기면서 사용하는 레이아웃
	 * 
	 * # methods
	 * 
	 * - CardLayout.first(parent) : 맨 처음 카드 보기
	 * - CardLayout.last(parent) : 마지막 카드 보기
	 * - CardLayout.next(parent) : 다음 카드 보기
	 * - CardLayout.previous(parent) : 이전 카드 보기
	 * - CardLayout.show(parent, card_name) : 원하는 카드 보기
	 * 
	 * */
	public S07_CardLayout() {
		setLayout(new BorderLayout());
		
		JPanel center = new JPanel();
		
		//JLabel : 내용을 그냥 출력 하는 곳
		JLabel label1 = new JLabel("Hello");
		JLabel label2 = new JLabel("Nice to meet you");
		JLabel label3 = new JLabel("Good bye");
		
		//카드 레이아웃에 컴포넌트를 추가할 때는 컴포넌트의 이름을 지정해 놓는 것이 좋다
		center.setLayout(new CardLayout(5,5));
		center.add("card1",label1);
		center.add("card2",label2);
		center.add("card3",label3);
		
		JPanel south = new JPanel();   //원래 패널도 클래스 파서 따로 만들어야함. 객체 지향적으로
		
		JButton prev = new JButton("prev");
		prev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//이전 카드로 넘기기 (레이아웃이 설정된 컨테이너의 인스턴스가 필요하다)
				CardLayout card = (CardLayout)center.getLayout();
				
				//첫 번째 라벨이 보이지 않을때만 이전 버튼이 동작함
				if(!label1.isVisible()) {
					card.previous(center);
				}
				//card.first(center);
			}
		});
		
		JButton next = new JButton("next");
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//다음 카드로 넘기기(레이아웃이 설정된 컨테이너의 인스턴스가 필요하다)
				CardLayout card = (CardLayout)center.getLayout();
				
				if(!label3.isVisible()) {
					card.next(center); //다음 카드로 넘기기 (부모 인스턴스 필요)					
				}
			}
		});
		
		south.setLayout(new GridLayout(1,2));
		south.add(prev);
		south.add(next);
		
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
		setSize(300,300);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new S07_CardLayout();
	}
}










