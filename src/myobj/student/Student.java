package myobj.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Student {
	Random ran;
	int[] score;
	int sum;
	double average;
	String[] lastName = {"은","승","희","미","성","혁","태","연","지","주","유","예","영","슬","주",
			"지","수","재","환","의","하","리","설","현","보","영","우","빈","종","석","광","현",
			"인","성","원","병","진","희","동","규","명","석","민","다","소","솔","경","선"};
	String[] firstName = {"김","나","박","이","신","조","홍","최","배","구","노","송","황","곽","서",
			"심","오","손","윤","장","정","강","권","고","남"};
	String fullName;
	boolean[] nameCheck;
	
	public Student() {
		ran = new Random();
		score = new int[3];
		for (int i = 0; i < score.length; i++) {
			score[i] = ran.nextInt(101);
			sum += score[i];
		}	
	}
	
	public int getSum() {
		return sum;
	}
	
	public double average() {
		average = sum / (double)score.length;
		return average = Math.round(average * 100) / 100.0; 
	}
	
	public String toName() {
		int firIndex = 0, middleIndex = 0, lastIndex = 0;
		nameCheck = new boolean[lastName.length];
		firIndex = ran.nextInt(firstName.length);
		middleIndex = ran.nextInt(lastName.length);
		
		nameCheck[middleIndex] = true;
		
		while(true) {
			if (nameCheck[lastIndex] == false) {
				lastIndex = ran.nextInt(lastName.length);
				break;
			}
		}
		
		return fullName = firstName[firIndex] + lastName[middleIndex] + lastName[lastIndex];
		
	}
	
	public void studentOutput() {
		System.out.println("이름\t국어\t영어\t수학\t평균");
		System.out.printf("%s\t%3d\t%3d\t%3d\t%.2f\n",fullName, score[0], score[1], score[2], average);
	}

}










