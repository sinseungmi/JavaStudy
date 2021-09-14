package myobj.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FiveDice {

	Random ran;
	int[] dice;
	int[] diceCount;
	int kindOfDice;

	public FiveDice() {
		dice = new int[5];
		ran = new Random();

		reroll(new int[] { 1, 2, 3, 4, 5 });  //일단 처음에 무조건 5개를 다 굴린다
	}

	private void countCheck() { //각 주사위가 나온 횟수를 생성
		diceCount = new int[6];

		for (int i = 0; i < dice.length; ++i) {
			diceCount[dice[i] - 1]++;   //dice엔 random 값이 들어갔는데 그 값은 1 ~ 6까지임. 
			//근데 diceCount는 0 ~ 5까지 인덱스가 존재하기 때문에 dice의 count를 셀라면 -1을 해야한다. 
		}
	}

	private void kindCheck() {
		kindOfDice = 0;

		for (int i = 0; i < 6; ++i) {
			if (diceCount[i] > 0) {  //diceCount[i] : countCheck에서 각 주사위가 나온 횟수를 생성 했는데
				//그 횟수 가지고 0 이상의 값일 땐 kindOfDice를 올린다. 0미만일 땐 if문이 동작을 안할 것이고 
				//그럼 kindOfDice도 카운트가 안되겠지? 이렇게 해서 주사위 눈의 갯수를 셀 수 있다
				kindOfDice++;   
			}
		}
	}

	// 아까 계산해놓은 주사위 개수 배열에 원하는 개수가 존재하는지 체크
	private boolean countContains(int count) {
		for (int i = 0; i < diceCount.length; ++i) {
			if (diceCount[i] == count) {
				return true;
			}
		}
		return false;
	}

	private boolean checkLarge() {
		if (diceCount[0] == 0 || diceCount[5] == 0) {
			return true;
		}

		return false;
	}

	private boolean checkSmall() {
		for (int i = 0; i < 3; ++i) {
			if (diceCount[i] > 0 && diceCount[i + 1] > 0 && diceCount[i + 2] > 0 && diceCount[i + 3] > 0) {
				return true;
			}
		}
		return false;
	}

	public void check() {
		countCheck(); // 각 주사위가 나온 횟수를 생성
		kindCheck(); // 나온 눈의 종류를 생성(눈이 중복빼고 몇개 나왔는지)

		System.out.println("집계 결과: " + Arrays.toString(diceCount));
		System.out.println("주사위 눈의 종류: " + kindOfDice);

		if (kindOfDice == 1) {
			System.out.println("Five Dice!!!");
		} else if (countContains(4)) {
			System.out.println("Four Dice!!");
		} else if (kindOfDice == 2 && countContains(3)) {
			System.out.println("Full House!!");
		} else if (kindOfDice == 5 && checkLarge()) {   
			System.out.println("Large Straight!!");
		} else if (checkSmall()) {
			System.out.println("Small Straight!");
		}
	}

	public void reroll(int index) {
		if (index < 1 || index > 5) {
			System.out.println("인덱스가 이상함");
			return;
		}

		dice[index - 1] = ran.nextInt(6) + 1;
		System.out.println("리롤 결과: " + Arrays.toString(dice));
	}

	public void reroll(int[] indexes) {  
		if (indexes.length > 5 || indexes.length == 0) {
			System.out.println("이상해서 안굴림");
			return;
		}

		for (int i = 0; i < indexes.length; ++i) {
			dice[indexes[i] - 1] = ran.nextInt(6) + 1;  //
		}    //예를 들어  아래 new int[] {3,5} 했을 때, 여기서 0번째에는 3이들어가고 1번째는 5가 들어간다

		System.out.println("리롤 결과: " + Arrays.toString(dice));
		check();
	}

	public static void main(String[] args) {
		FiveDice mydice = new FiveDice();

		mydice.reroll(new int[] { 1, 2, 3, 4, 5 });
		mydice.reroll(new int[] { 3, 5 });
		mydice.reroll(new int[] { 1, 4 });
		mydice.reroll(new int[] { 1, 2, 3 });
	}

}




















