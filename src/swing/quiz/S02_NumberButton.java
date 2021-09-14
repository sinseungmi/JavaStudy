package swing.quiz;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;

public class S02_NumberButton extends JButton{
	
	public S02_NumberButton(int x, int y) {
		super("0");
		
		setFont(new Font("Consolas",Font.BOLD,30));
		setSize(80, 80);
		setLocation(new Point(x, y));
		
	}

}
