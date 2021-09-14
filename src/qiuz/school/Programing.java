package qiuz.school;

import java.util.Arrays;

public class Programing extends C07_School{
	
	int[] math = new int[classNum.length];
	int[] programing = new int[classNum.length];
	
	public Programing() {
		//super();  이 슈퍼는 굳이 안불러도 된다. default super는 자동으로 불려지기 때문이다
		for (int i = 0; i < math.length; i++) {
			this.math[i] = (int)(Math.random() * 101);
			this.programing[i] = (int)(Math.random() * 101);
		}
	}
	
	public String reportCard() {
		for(int i = 0; i < classNum.length; i++) {
			super.sum = super.kor[i] + super.eng[i] + math[i] + programing[i];
			super.aver = super.sum / (double)4;
			super.reportCard[i] = "이름:" + fullName[i] + "/총점:" + super.sum + "점/평균:"
			+ super.aver + "점/번호:" + classNum[i] + "번\n";
		}
		return Arrays.toString(super.reportCard);
	}
}








