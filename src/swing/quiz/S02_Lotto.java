package swing.quiz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S02_Lotto {
	
	/*
	 * "뽑기"버튼을 누를 때마다 6개의 중복 없는 랜덤 숫자를 가진
	 * 버튼을 프레임에 띄우는 프로그램을 만들어보세요
	 * 
	 * */
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JButton btn = new JButton("뽑기");
		JButton btn1 = new JButton("랜덤 숫자1");
		JButton btn2 = new JButton("랜덤 숫자2");
		JButton btn3 = new JButton("랜덤 숫자3");
		JButton btn4 = new JButton("랜덤 숫자4");
		JButton btn5 = new JButton("랜덤 숫자5");
		JButton btn6 = new JButton("랜덤 숫자6");
	
		frame.setLayout(new BorderLayout());
		btn1.setSize(100,100);
		btn2.setSize(100,100);
		btn3.setSize(100,100);
		btn4.setSize(100,100);
		btn5.setSize(100,100);
		btn6.setSize(100,100);
		btn.setSize(100,100);
		btn.setLocation(500, 300);
		btn1.setLocation(100, 100);
		btn2.setLocation(200, 100);
		btn3.setLocation(300, 100);
		btn4.setLocation(400, 100);
		btn5.setLocation(500, 100);
		btn6.setLocation(600, 100);
		
		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(btn4);
		frame.add(btn5);
		frame.add(btn6);
		frame.add(btn);
		
		frame.setVisible(true);
		frame.setSize(800,600);
		frame.setLocation(800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				HashSet<Integer> hash = new HashSet<Integer>();
				
				while (hash.size() != 6) {
					int ran = (int)(Math.random() * 45 + 1); //해쉬는 중복 제거~
					
					hash.add(ran);
					
				}
				ArrayList<Integer> list = new ArrayList<>(hash);
				
				btn1.setText(Integer.toString(list.get(0)));
				btn2.setText(Integer.toString(list.get(1)));
				btn3.setText(Integer.toString(list.get(2)));
				btn4.setText(Integer.toString(list.get(3)));
				btn5.setText(Integer.toString(list.get(4)));
				btn6.setText(Integer.toString(list.get(5)));
				
				
			}
		});
		
	}
	
	
	
	
	

}

























