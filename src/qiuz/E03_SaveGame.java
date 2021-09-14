package qiuz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class E03_SaveGame {

	/*
	 * 1.컴퓨터와 진행하는 간단한 가위바위보 게임을 만들어라 
	 * -처음 시작하면 이름을 입력함 
	 * -프로그램 종료시 플레이어의 전적을 파일을 저장해보세요 (저장할 때 파일명은 이름.txt)
	 * 
	 * 2.프로그램 실행시 이름을 입력했을 때 해당 전적이 있다면 전적을 불러온 후 진행되도록 만들어보세요
	 * 
	 */

	String name;
	int totalCount;
	int victory;
	int defeat; 
	int draw;  //무승부

	public E03_SaveGame(String name) {
		this.name = name;
		
		record();
	}
	
	public void record() {
		
		String countStr = null;
		try {										//경로는 컴파일로(실행됐을 때를) 따져야한다.
											//프로젝트 폴더 단위로 경로를 지정한다 생각하면 됨.
											//그래서 현재 위치가 src가 아닌 javaStudy인 것.
			FileInputStream fin = new FileInputStream(String.format("./%s.txt", name));
			
			byte[] buffer = new byte[500];
			
			int len;         //buffer크기 만큼 읽어서 배열을 채우고 읽어 온 데이터의 수를 반환.
			while((len = fin.read(buffer)) != -1 ) {
				countStr = new String(buffer, 0, len);
			}
			
			String[] record = countStr.split(" ");
		
//			int totalIndex = countStr.indexOf("판");
//			int victoryIndex = countStr.indexOf("승");
//			int drawIndex = countStr.indexOf("무");
//			int defeaIndex = countStr.indexOf("패");
			
			totalCount = Integer.parseInt(record[0].substring(0,record[0].length() - 1));
			victory = Integer.parseInt(record[1].substring(0,record[1].length() - 1));
			draw = Integer.parseInt(record[2].substring(0,record[2].length() - 1));
			defeat = Integer.parseInt(record[3].substring(0,record[3].length() - 1));
			
			System.out.printf("전적 : %d판 %d승 %d무 %d패\n", totalCount,victory,draw,defeat);
			play();
		} catch (FileNotFoundException e) {
			play();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void gameStart(int userPlay, int comPlay) {
		totalCount++;
		if (userPlay == comPlay) {
			System.out.println("무승부");
			draw++;
		} else if ((userPlay == 1 && comPlay == 3) || (userPlay == 2 && comPlay == 1)
				|| (userPlay == 3 && comPlay == 2)) {
			System.out.println("user 승!");
			victory++;
		} else {
			System.out.println("com 승!");
			defeat++;
		}
	}

	public void play() {
		Scanner sc = new Scanner(System.in);
		int turn = 1;
		int userPlay = 0;
		int comPlay = 0;
		String comStr = null;
		String userStr = null;

		while (true) {
			System.out.println("1.게임 시작\n2.나가기");
			int choose = sc.nextInt();
			if (choose == 1) {
				while (true) {
					if (turn == 1) {
						System.out.print("1.가위 2.바위 3.보 중 하나를 선택하세요(종료는 0): ");
						userPlay = sc.nextInt();
						if (userPlay == 1) {
							userStr = "가위";
						} else if (userPlay == 2) {
							userStr = "바위";
						} else if (userPlay == 3) {
							userStr = "보";
						} else if (userPlay == 0) {
							System.out.println("게임을 종료하겠습니다.");
							if (totalCount > 0) {
								File f = new File(String.format("./%s.txt", name));

								try {
									FileOutputStream fs = new FileOutputStream(f);
									
									String totalStr = totalCount + "판 ";
									String victoryStr = victory + "승 ";
									String drawStr = draw + "무 ";
									String defeatStr = defeat + "패 ";
									
									fs.write(totalStr.getBytes());
									fs.write(victoryStr.getBytes());
									fs.write(drawStr.getBytes());
									fs.write(defeatStr.getBytes());
									
									fs.close();
								} catch (FileNotFoundException e) {
									e.printStackTrace();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}

							return;
						} else {
							System.out.println("잘못 누르셨습니다. 다시 입력하세요");
							continue;
						}

						turn = 0;
					}
					if (turn == 0) {
						comPlay = (int) (Math.random() * 3 + 1);

						switch (comPlay) {
						case 1:
							comStr = "가위";
							break;
						case 2:
							comStr = "바위";
							break;
						case 3:
							comStr = "보";
							break;
						}
						turn = 1;
					}
					System.out.printf("user : %s VS com : %s\n", userStr, comStr);

					gameStart(userPlay, comPlay);

				}

			} else if (choose == 2) {
				return;
			}
		}

	}

	public static void main(String[] args) {

		System.out.println("이름을 입력하세요 :");
		String userName = new Scanner(System.in).next();
		E03_SaveGame sg = new E03_SaveGame(userName);
		

	}
}
