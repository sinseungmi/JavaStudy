package swing;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import swing.quiz.S03_KakaoImageButton;

public class S03_JButton extends JFrame {
	
	private static final long seriaVersionUID = 1L;
	
	public S03_JButton() {
		setLayout(null);
		
		JButton btn1 = new JButton("눌러보세요");

		//setBounds(x, y, width, height) : 버튼의 위치와 크기 설정을 한번에 한다
		btn1.setBounds(100, 100, 150, 150);
		
		//setText() : 해당 컴포넌트의 텍스트를 변경한다
		btn1.setText("Push this button!");
		
		//setEnabled() : 해당 컴포넌트를 활성화/비활성화 한다
		btn1.setEnabled(true);
		
		//setBackground() : 해당 컴포넌트의 배경색을 변경한다
		btn1.setBackground(new Color(255,255,0));
		
		//setIcon() : 해당 컴포넌트의 아이콘을 설정한다
		btn1.setIcon(new ImageIcon("./data/kakao.jpg"));

		add(btn1);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,800);
		setLocation(1000,50);
		setVisible(true);
		
		
	}

	
	public static void main(String[] args) {
		new S03_JButton();
	}


}
