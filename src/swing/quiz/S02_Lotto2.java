package swing.quiz;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S02_Lotto2 extends JFrame{
	
	public S02_Lotto2() {
		setLayout(null);  //setLayout 메소드는 JFrame에 얹을 컴포턴트의 배치 방법을 지정하는 메소드이다.
		         //내가 원하는 위치로 지정하고 싶을 때는 null로 설정한다.
		
		ArrayList<JButton> btns = new ArrayList<>();
		
		btns.add(new S02_NumberButton(100, 100));
		btns.add(new S02_NumberButton(200, 100));
		btns.add(new S02_NumberButton(300, 100));
		btns.add(new S02_NumberButton(400, 100));
		btns.add(new S02_NumberButton(500, 100));
		btns.add(new S02_NumberButton(600, 100));
		
		JButton nextBtn = new S02_NextButton(100, 300, btns);
		
		for(JButton btn : btns) {
			add(btn);
		}
		
		add(nextBtn);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(1000,500);
		setSize(1000,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new S02_Lotto2();
	}
	
	
	
	

}









