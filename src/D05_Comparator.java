import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class D05_Comparator {
	
	/*
	 * Comparator
	 * 
	 * - 구현하면 두 객체의 크기를 비교할 때 사용하는 클래스가 되는 인터페이스
	 * - 객체간의 크기를 정할 때 사용된다
	 * 
	 * */
	public static void main(String[] args) {
		String str1 = "yes";
		String str2 = new String("yes");
		
		System.out.println("str1 == str2: " + (str1 == str2));
		System.out.println("str1.equals(): " + str1.equals(str2));
		
		Grape podo1 = new Grape().setGno("PODO1588");
		Grape podo2 = new Grape().setGno("PODO1588");
		
		System.out.println(podo1 == podo2);
		System.out.println(podo1.equals(podo2));
		
		LinkedList<Grape> grapes = new LinkedList<>();
		
		for (int i = 0; i < 10; i++) {
			grapes.addLast(new Grape()
					.setGno(String.format("PODO%04d", i))
					.setLocation((int)(Math.random() * Grape.LOCATIONS))
					.setFruit((int)(Math.random() * 11 + 30)));
			System.out.println(grapes.getLast());
		}
		
		//포도는 무엇을 기준삼아 정렬될까
		Collections.sort(grapes, new 포도분류기_포도알맹이_오름차순());
	
		System.out.println("\n#### 정렬 후 ###");
		for (Grape grape : grapes) {
			System.out.println(grape);
		}
		
		//연습1 : 포도 알맹이 기준 내림차순 정렬해보기
		Collections.sort(grapes, new 포도분류기_알맹이기준_내림차순());
		
		System.out.println("\n#### 알맹이 기준 내림차순 ###");
		for (Grape grape : grapes) {
			System.out.println(grape);
		}
	
		//연습2 : 포도 gno 기분 내림차순 정렬해보기
		Collections.sort(grapes, new 포도분류기_GNO기준_내림차순());
		
		System.out.println("\n#### GNO 기준 내림차순 ###");
		for (Grape grape : grapes) {
			System.out.println(grape);
		}
		
	}
}

class 포도분류기_GNO기준_내림차순 implements Comparator<Grape>{

	@Override
	public int compare(Grape o1, Grape o2) {
		
		//문자열의 크기 비교는 이미 string 클래스의 compareTo메서드에 구현되어 있다
		return o1.gno.compareTo(o2.gno) * -1; //기본은 오름차순 정렬이기 때문에 내림차순으로하고 싶다면 -1을 곱하면 된다
		
		/*int gnoNum, gnoNum2;
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		for(int i = 4; i < o1.gno.length(); i++) {
			sb.append(o1.gno.charAt(i));
			sb2.append(o2.gno.charAt(i));
		} 
		
		gnoNum = Integer.parseInt(sb.toString());
		gnoNum2 = Integer.parseInt(sb2.toString());
		
		if(gnoNum < gnoNum2) {
			return 1;
		}else if (gnoNum == gnoNum2){
			return 0;
		}else {
			return -1;
		}*/
	
	}
	
}

class 포도분류기_알맹이기준_내림차순 implements Comparator<Grape>{
	
	@Override
	public int compare(Grape o1, Grape o2) {
		if (o1.fruit < o2.fruit) {
			return 1;
		}else if (o1.fruit == o2.fruit) {
			return 0;
		}else {
			return -1;
		}
		
	}
}

class 포도분류기_포도알맹이_오름차순 implements Comparator<Grape>{
	/*
	 * Comparator의 규칙
	 * 
	 * - compare 메서드의 리턴 값이 양수이면 o1과 o2의 순서를 바꾼다
	 * - compare 메서드의 리턴 값이 0이면 같은 크기로 취급한다
	 * - compare 메서드의 리턴 값이 음수이면 o1과 o2의 순서를 그대로 유지한다
	 * 
	 * */
	
	@Override
	public int compare(Grape o1, Grape o2) {
		if (o1.fruit < o2.fruit) {
			return -1;
		}else if (o1.fruit == o2.fruit) {
			return 0;
		}else {
			return 1;
		}
		
	}
}

//this 키워드는 이 클래스를 기반으로 생성된 인스턴스를 가리키는 참조
class Grape{
	private static String[] locationNames = {"말레이시아","종로","강남","영등포","신도림"};
	public static int LOCATIONS = locationNames.length;
	
	String gno;
	int location;
	int fruit;
	
	Grape setGno(String gno) {
		this.gno = gno;
		return this;          //Grape 인스턴스를 반환
	}
	Grape setLocation(int location_id) {
		location = location_id;
		return this;
	}
	Grape setFruit(int fruit) {
		this.fruit = fruit;
		return this;
	}
	
	/*
	 * equals()
	 * 
	 * - Object 메서드
	 * - 같은 객체인지 비교할 때 어떤 동작으로 구분해야 하는지를 구현해놓는 메서드
	 * - 기본 동작은 주소 값 비교
	 * 
	 * */
	
	@Override
	public boolean equals(Object obj) {
		return this.gno == ((Grape)obj).gno;
	}
	public boolean equals(Grape grape) {
		return this.gno == grape.gno;
	}
	
	/*
	 * toString()
	 * 
	 * - 모든 객체에 포함되어 있는 메서드 (Object 메서드)
	 * - 이 인스턴스를 문자열로 표현한다면? 을 구현해놓은 메서드
	 * - System.out.println()은 사실 전달한 인스턴스의 toString()
	 *   메서드의 결과를 콘솔에 출력하는 메서드이다
	 * - object 클래스에 구현되어 있는 toString() 메서드의 기본 동작은
	 *   "클래스 명@주소값"이다
	 * 
	 * */
	@Override
	public String toString() {
		return gno + "/" + fruit + "/" + locationNames[location] + "(" + location + ")";
	}
	
	
}
























