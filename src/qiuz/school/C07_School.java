package qiuz.school;

import java.util.Arrays;

abstract public class C07_School {
	
	/*
	 * 1. 각 반의 정원은 30명이다. 
	 * 2-2. 프로그래밍 반 학생은 각자의 국어, 영어, 수학, 프로그래밍 언어 점수가 있다
	 * 2-3. 네트워크 반 학생은 각자의 국어, 영어, 리눅스, CCNA 언어 점수가 있다
	 * 2-4. 머신러닝 반 학생은 각자의 국어, 영어, 수학, 통계학, 프로그래밍 언어 점수가 있다
	 * 3. 모든 학생의 점수를 랜덤으로 생성한다
	 * 	  학번은 중복없이 순차적으로! (또는 중복 없이 랜덤 / 이름 랜덤)
	 * 4. 성적표 메서드를 통해 각 학생의 [이름/총점/평균 점수]를 볼 수 있다
	 * 
	 * */
	
	int[] classNum = new int[30];
	String[] name = {"가영","아름","진솔","혁순","승준","희재","민호","동원","은지",
			"예슬","유나","연주","유리","태진","아영","나라","승미","성주","우빈"};
 	char[] name1 = {'김','박','나','신','이','최','권','원','백','홍','조','배','서','윤','장','황'};
	String[] fullName = new String[classNum.length];
 	int[] kor = new int[classNum.length];
 	int[] eng = new int[classNum.length];
 	//int a, b = 7; 변수를 여러개 지정하고 값을 넣으면 하나의 변수 안에만 들어간다!!! 위에 배열 여러개 지정하고 값을 넣었을 때
 	// null error가 나온 이유
 	int sum;
 	double aver;
 	String[] reportCard = new String[classNum.length];

	public C07_School() {
		for (int i = 0; i < kor.length; i++) {
			this.kor[i] = (int)(Math.random() * 101);
			this.eng[i] = (int)(Math.random() * 101);
		}
		for (int i = 1,j = 0; i <= 30; j++) {
			classNum[j] = i++;
		}
		
		for (int i = 0; i < classNum.length; i++) {
			int name1Index = (int)(Math.random() * name1.length); //Math.random 소괄호()!!!빼먹지마
			int nameIndex = (int)(Math.random() * name.length);
			
			fullName[i] = name1[name1Index] + name[nameIndex];
		}	
	}
	
	abstract public String reportCard(); 
	
	public static void main(String[] args) {
		C07_School school1 = new Network();
		C07_School school2 = new Programing();
		C07_School school3 = new MachineLearning();
		
		System.out.println(school1.reportCard()); //sysout!! 빼먹지마!
		System.out.println(school2.reportCard()); //sysout!! 빼먹지마!
		System.out.println(school3.reportCard()); //sysout!! 빼먹지마!
		
	}
}










