package qiuz.school;

import java.util.Arrays;

public class Network extends C07_School{
	
	int[] linux = new int[classNum.length];
	int[] CCNA = new int[classNum.length];
	
	public Network() {
		for (int i = 0; i < linux.length; i++) {
			this.linux[i] = (int)(Math.random() * 101);
			this.CCNA[i] = (int)(Math.random() * 101);
		}
	}
	
	public String reportCard() {
		for(int i = 0; i < classNum.length; i++) {
			super.sum = super.kor[i] + super.eng[i] + linux[i] + CCNA[i];
			super.aver = super.sum / (double)4;
			super.reportCard[i] = "이름:" + fullName[i] + "/총점:" + super.sum + "점/평균:"
					+ super.aver + "점/번호:" + classNum[i] + "번\n";
		}
		return Arrays.toString(super.reportCard);
	}
}








