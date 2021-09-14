package myobj.tong;

import java.util.Scanner;

public class C07_PirateGame {

	/*
	 * 1. 플레이어가 돌아가면서 원하는 곳에 칼을 찌른다 2. 잘못된 곳에 칼을 넣으면 해적 아저씨가 날아가며 게임에 패배한다
	 * 
	 */
	Scanner sc;

	Barrel barrel;
	int mode;

	int turn;
	int comPlTurn;
	int numOfPlayer;
	int slot;		//칼을 하나씩 꽂을 구멍(이거는 forked랑 연관이 있다. 칼을 꽂은 곳은 true로 만들어서 못꽂게해야하니까.
					//forked는 그래서 boolean타입이다)
	boolean gameEnd;

	public C07_PirateGame(int mode) {	   //여기는 해적게임 생성자
		this.barrel = new Barrel(10);      //통 인스턴스를 생성(미리 적은 통의 구멍 갯수를 인자 값으로 넘긴다)
		this.mode = mode;				   //어떤 모드로 할지 고른 값을 저장
		this.numOfPlayer = 2;			   //플레이어 인원은 수를 정한다
		this.sc = new Scanner(System.in);  //입력해야하니까 스캐너 생성
	}

	public C07_PirateGame(int mode, int numOfPlayer) {
		this(mode);
		this.numOfPlayer = numOfPlayer;
	}

	public void start() {			//이제 게임 시작
		switch (this.mode) {		//해적게임 인스턴스를 생성했을 때 저장했던 어떤 모드 값을 불러온다
		case 0:
			//pvp();
			break;
		case 1:
			pvc();
			break;
		default:
			System.out.println("아직 구현되지 않은 모드");
			break;
		}

	}

	public void config(int mode) {  //모드 다시 고르기
		this.mode = mode;
	}

//	void pvp() {
//		while (gameEnd) {
//			System.out.println((turn + 1) + "턴");
//			System.out.println("Player" + (turn % numOfPlayer + 1) + "의 차례 >");
//			this.slot = sc.nextInt();
			//	if (barrel.fork(slot)) {
			//		gameEnd = true;
			//		if (barrel.checkGameOver()) {
			//			System.out.println("통아저씨가 날아갔습니다");
			//			System.out.println("Player" + (turn % numOfPlayer + 1) + "의 패배");
			//			gameEnd = false;
			//		}
//			
//			func(slot);
//			
//			turn++;
//			
//		}
//	}


	void func() {
		
			if (barrel.fork(slot)) {
		
				if (barrel.checkGameOver()) {
					System.out.println("통아저씨가 날아갔습니다");
					System.out.println((comPlTurn == 1 ? "Player" : "Com") + "의 패배");
					gameEnd = false;
				}
			}
			turn++;
			
		}
	
	

	void pvc() {

		comPlTurn = (int)(Math.random() * 2);
		turn = 0;

		while (true) {
			if (comPlTurn == 0) {
				System.out.println((turn + 1) + "턴");
				System.out.println("Player의 차례 > ");
				this.slot = sc.nextInt();
				func();

				comPlTurn = 1;
			} else if (comPlTurn == 1) {
				System.err.println((turn + 1) + "턴");
				System.out.println("Com의 차례 > ");
				this.slot = barrel.comRan();
				func();

				comPlTurn = 0;
			}

		}

	}

	public static void main(String[] args) {
		C07_PirateGame testGame = new C07_PirateGame(1, 3); 

		// testGame.start();
		//testGame.config(0);
		testGame.start();

		System.out.println("테스트 게임 끝");
	}

}


















