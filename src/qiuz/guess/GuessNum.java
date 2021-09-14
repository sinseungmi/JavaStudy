package qiuz.guess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GuessNum {

//	 3. 맞춘 시간과 횟수를 통해 1위부터 30위까지의 랭킹을 생성해 파일에 저장한다
//  	(횟수가 같다면 시간이 더 적게 걸린사람이 상위 랭킹)
//
//	 4. 새로운 게임을 시작할때마다 랭킹을 출력해준다
//                
//	※ 맞추고 나면 몇 번만에 맞췄는지 알려주고 랭크에도 반영한다

	
	long endTime, startTime;
	long timeTaken;
	String name;
	int count;
	static ArrayList<GuessNumPlay> list = new ArrayList<>();
	
	
	public static void main(String[] args) {
		GuessNum gn = new GuessNum();
		System.out.print("이름을 입력하세요 : ");
		String name = new Scanner(System.in).next();
		gn.gameStart(name);
	}
	
	public void ranking(ArrayList<GuessNumPlay> list) {
		Collections.sort(list, new RankingComparator());
		
		System.out.println(list.toString());
		
	}
	
	public ArrayList<GuessNumPlay> save(GuessNumPlay gnp) {
		
		list.add(gnp);
		
		return list;	
	}
	
	public void gameStart(String name) {
		
		File file = new File("./data/%s.txt", name);
		
		if(file.exists()) {
			//맞춘시간과 횟수를 불러온다
		}
		

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			sb.append((int)(Math.random() * 10));
		}
		String number = sb.toString();
		
		Scanner sc= new Scanner(System.in);
		String input = null;
		boolean bool = true;
		int attempt = 1;
		
		System.out.println(number);
		
		
		while (attempt <= 8) {
			int strike = 0, ball = 0;
			System.out.print(attempt++ + "번째 시도 : ");
			input = sc.next();
			while (bool) {
				startTime = System.currentTimeMillis() / 1000;
				
				for (int i = 0; i < 4; i++) {
					if(input.charAt(i) >= '0' && input.charAt(i) <= '9') {
						if (input.length() == 4) {
							bool = false;
						}else {
							System.out.println("입력 숫자를 초과하였습니다.");
							continue;
						}
					}else {
						System.out.println("숫자만 입력해주세요");
						continue;
					}
				}

			}
		
			
			if (number.equals(input)) {
				endTime = System.currentTimeMillis() / 1000;
				timeTaken = endTime - startTime;
				strike = 4;
				count = attempt;
				System.out.println(strike + ":strike " + ball + ":ball");
			
				GuessNumPlay gnp = new GuessNumPlay(name, count, timeTaken);
				ranking(save(gnp));
				
				break;
			}
			for(int i = 0; i < 4; i++) {
				if (number.charAt(i) == input.charAt(i)) {
					strike++;
				}else {
					for (int j = 0; j < 4; j++) {
						if (number.charAt(i) == input.charAt(j)) {
							ball++;
							
							break;  //number에서 같은 걸 하나 찾았을 때 break
						}
					}
					
				}
			}
			
			System.out.println(strike + ":strike " + ball + ":ball");
		}
		
	}
}
