package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class S04_JTable extends JFrame{
	
	public S04_JTable() {
		Container container = getContentPane();
		setLayout(new BorderLayout(50,50));  
		                           //컴포넌트들간에 여백 설정
		
		String data[][] = {
				{"100","Smith","3500","10"},	
				{"101","King","4500","30"},	
				{"102","Steve","50000","10"},	
				{"103","Ryo","30","10"}	
		};
		
		
		String[] column = {"ID","NAME","SALARY","DEPTNO"};
		
		JTable table = new JTable(data,column);
		
//		DefaultTableModel model = (DefaultTableModel)table.getModel();
//		
//		model.addRow(data[0]);
//		model.addRow(data[1]);
//		model.addRow(data[2]);
//		model.addRow(data[3]);
		
		add(table, BorderLayout.CENTER);
		add(new JButton("Hello,Swing"), BorderLayout.SOUTH);
		add(new JButton("Hello,Swing"), BorderLayout.EAST);
		add(new JButton("Hello,Swing"), BorderLayout.NORTH);
		add(new JButton("Hello,Swing"), BorderLayout.WEST);
		//처리(이벤트)와 디자인을 분리해야한다. 처리를 따로 하고 디자인에 붙여라
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				container.setBackground(Color.BLUE);		
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				container.setBackground(Color.GREEN);
					
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				container.setBackground(Color.RED);
	
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				container.setBackground(Color.BLACK);
				
			}
			
		});
		
		//컴포넌트에 대한 다양한 이벤트 추가, 어댑터를 가져오면 원하는 것만 구현해도 된다. 컴포넌트리스너는 다~구현해야해서 피곤
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Component com = e.getComponent();
				System.out.println("-------------------------");
				System.out.println("location - (" + com.getX() + "," + com.getY() + ")");
				System.out.println("size - (" + com.getWidth() + "," + com.getHeight() + ")");
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(1000,50,800,800);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new S04_JTable();
	}

}




















