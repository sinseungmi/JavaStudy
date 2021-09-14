package swing.quiz;

import java.awt.Font;
import java.util.List;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.swing.Action;
import javax.swing.JButton;

public class S02_NextButton extends JButton implements ActionListener{

	ArrayList<JButton> btns;
	
	public S02_NextButton(int x, int y, ArrayList<JButton> btns) {
		super("뽑기");  //JButton quit_btn = new JButton("Quit") 이거랑 같은 거임.
		
		this.btns = btns;
		
		setFont(new Font("돋움", Font.PLAIN, 30));
		setSize(800, 50);
		setLocation(new Point(x,y));  //위치 좌표 찍기
		addActionListener(this);  //포도분류기랑 비슷하다 생각하면 됨. 액션이 내 자신 안에 있어서 this라함
		
	}
	
	private static List<Integer> getLotto_list(){
		List<Integer> list = new ArrayList<>(45);
		
		for (int i = 1; i <= 45; i++) {
			list.add(i);
		}
		return list;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		List<Integer> numbers = getLotto_list();
		Collections.shuffle(numbers);
		
		numbers = numbers.subList(0, 6); //list를 0부터 6까지 자른다.
		//Collections.sort(numbers);
		
		for (JButton btn : btns) {
			btn.setText(numbers.remove(0).toString());
		}
		
		((JButton)e.getSource()).setText("한번 더 뽑기!");
		
	}
	
	
}




