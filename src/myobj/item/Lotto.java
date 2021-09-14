package myobj.item;

import java.util.Arrays;

public class Lotto extends Item{
	
	int[] lottoNum = new int[7];
	
	public Lotto(String name, int price) {
		super(name, price);
		System.out.println("로또를 생성하겠습니다");
		int number;
		
		for (int i = 0; i < 7; i++) {
			number = (int)(Math.random() * 45 + 1);
			lottoNum[i] = number;
		}
	}
	
	public void use() {
		System.out.println(Arrays.toString(lottoNum));
	}

}







