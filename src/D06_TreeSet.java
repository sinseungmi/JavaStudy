import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

import myobj.poker.Card;

public class D06_TreeSet {

	/*
	 * # TreeSet
	 * 
	 * - 정렬과 크기 비교에 특화된 셋
	 * - 중복값을 저장할 수 없다 
	 * - 데이터를 저장할 때 Comparator를 이용해 미리 정렬한다 
	 * - 요소로 null을 허용하지 않는다 
	 * - 처음에 정렬해서 넣기 때문에 HashSet에 비해 저장 속도가 느리다 
	 * - 하지만 TreeSet은 정렬이 미리 되어있기 때문에 정렬된 순서로 데이터를 꺼내는 것은
	 *   가장 빠르다
	 */

	public static void main(String[] args) {
		TreeSet<Grape> grape_tree = new TreeSet<>(new 포도분류기_GNO기준_내림차순());
		TreeSet<Grape> grape_tree2 = new TreeSet<>(new 포도분류기_포도알맹이_오름차순());
		
		//해당 객체 자체가 비교 가능한 객체라면 comparator를 사용하지 않을 수 있다
		//TreeSet<Mango> mango_tree = new TreeSet<>(new MangoCompareBySweetAsc());
		TreeSet<String> word_tree = new TreeSet<>();
		TreeSet<Mango> mango_tree = new TreeSet<>();
		
		for(int i = 0; i < 5; i++) {
			mango_tree.add(
					new Mango("MANGO"+ 
			String.format("%05d", (int)(Math.random() * 100000)),10,10));
			
		}

		
		grape_tree.add(new Grape().setGno("1").setFruit(37));
		grape_tree.add(new Grape().setGno("2").setFruit(31));
		grape_tree.add(new Grape().setGno("3").setFruit(40));
		grape_tree.add(new Grape().setGno("4").setFruit(37));

		grape_tree2.addAll(grape_tree);

		System.out.println(grape_tree);
		System.out.println(grape_tree2);
		
		word_tree.add("cat");
		word_tree.add("pet");
		word_tree.add("pat");
		word_tree.add("fat");
		word_tree.add("bat");
		
		System.out.println(word_tree);
		System.out.println(mango_tree);

		//TreeSet 활용
		
		//descendingSet() : 미리 정렬해 놓은 방향의 반대 방향의 set 인스턴스를 반환
		System.out.println(grape_tree.descendingSet());
		                  //3미만을 잘라라 항상 처음은 포함 마지막은 미만
		//headSet(toElement) : 맨 앞부터 원하는 요소까지 자른 Set을 반환
		System.out.println(grape_tree.headSet(new Grape().setGno("3")));
		
		//tailSet(toElement) : 원하는 요소부터 맨 뒤까지 자른 Set을 반환
		System.out.println(grape_tree.tailSet(new Grape().setGno("3")));
	
		//subSet(fromElement, toElement) : 원하는 요소부터 시작해서 원하는 요소까지 자른 set을 반환
		System.out.println(grape_tree.subSet(new Grape().setGno("3"), new Grape().setGno("1")));
		
		TreeSet<Integer> int_tree = new TreeSet<>();
		
		int_tree.add(99);
		int_tree.add(5);
		int_tree.add(15);
		int_tree.add(9);
		int_tree.add(7);
		int_tree.add(21);
		int_tree.add(60);
		int_tree.add(23);
		
		System.out.println(int_tree);
		
		//ceiling(element) : 원하는 가장 가까운 요소를 올려서 선택 (전달한 값도 포함)
		System.out.println(int_tree.ceiling(20));
		System.out.println(int_tree.ceiling(21));
		System.out.println(int_tree.ceiling(22));
		
		//floor(element) : 원하는 가장 가까운 요소를 내려서 선택 (전달한 값도 포함)
		System.out.println(int_tree.floor(20));
		System.out.println(int_tree.floor(21));
		System.out.println(int_tree.floor(22));
		
		//higher(element) : 원하는 가장 가까운 요소를 올려서 선택 (전달한 값 미포함)
		System.out.println(int_tree.higher(21));
		
		//lower(element) : 원하는 가장 가까운 요소를 내려서 선택 (전달한 값 미포함)
		System.out.println(int_tree.lower(21));
		
		// 연습문제: 망고트리에 망고를 5개 추가할때 mno기준 오름차순 정렬이 되도록 만들고 확인
	    // sysout으로 출력할 때 보기 좋게 나와야 함 (망고 주소 X)
		//new Mango("1234",12,123).setMno("4321");
	
		
		
	}

}												//망고의 comprator라고 읽으면 이해하기 쉬움
                                                //Mango만 들어갈 수 있다(Mango전용 comparator를 구현하겠다)
class MangoCompareBySweetAsc implements Comparator<Mango> {
	/*
	 * # Comparator의 규칙
	 * 
	 * - compare 메서드의 리턴 값이 1이면 o1과 o2의 순서를 바꾼다 
	 * - compare 메서드의 리턴 값이 0이면 같은 크기로 취급한다
	 * - compare 메서드의 리턴 값이 -1이면 o1과 o2의 순서를 그대로 유지한다
	 */
	@Override
	public int compare(Mango o1, Mango o2) {
		if (o1.sweet > o2.sweet) {
			return 1;
		} else if (o1.sweet < o2.sweet) {
			return -1;
		} else {
			return 0;
		}
	}
	
}

//comparator : 비교할 때 사용하는 비교 도구 클래스로 만드는 인터페이스
//comparable : 이 객체가 비교 가능한 클래스임을 표시하는 인터페이스
class Mango implements Comparable<Mango>{
	String mno;
	int sweet;
	int size;

	public Mango(String mno, int sweet, int size) {
		this.mno = mno;
		this.sweet = sweet;
		this.size = size;
	}
	Mango setMno(String mno) {
		this.mno = mno;
		return this;
	}
	//this vs 매개변수로 compare 메서드를 구현하면 된다
	@Override
	public int compareTo(Mango o) {
		return this.mno.compareTo(o.mno);
	}
	
	@Override
	public String toString() {
		return mno + "/" + sweet + "/" + size;
	}
	
}
