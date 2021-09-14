package qiuz.school;

import java.util.Arrays;

public class MachineLearning extends Programing{
	
	int[] Statistics = new int[classNum.length];
	
	public MachineLearning() {
		for (int i = 0; i < Statistics.length; i++) {
			this.Statistics[i] = (int)(Math.random() * 101);
		}
	}
	
	public String reportCard() {
		for(int i = 0; i < classNum.length; i++) {
			super.sum = super.kor[i] + super.eng[i] + Statistics[i];
			super.aver = super.sum / 4.0;
			
			super.reportCard[i] = "이름:" + fullName[i] + "/총점:" + super.sum + "점/평균:"
					+ super.aver + "점/번호:" + classNum[i] + "번\n";
		}
		return Arrays.toString(super.reportCard);
	}
}






