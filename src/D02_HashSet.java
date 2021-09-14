import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class D02_HashSet {
	
	/*
	 * # Set
	 * 
	 * - 집합을 구현해놓은 클래스
	 * - 요소로 같은 값이 들어오는 것을 허용하지 않는다
	 * 
	 * # Hash
	 * 
	 * - 어떤 값을 넣었을 때 전혀 예측할 수 없는 값이 생성되어야하는 알고리즘
	 * - 같은 값을 넣었을 때는 항상 일정한 값이 나와야 한다
	 * - 유사한 값을 넣었을 때 예측하기 힘든 전혀 다른 값이 나온다
	 * - 생성된 해쉬값으로 원래 값을 찾는 것이 불가능해야한다
	 * - 다시 원래 값으로 돌아갈 수도 없는 단방향성 알고리즘
	 * - 중복 체크시에 뛰어난 성능을 보인다
	 * - 조금의 수정도 파악할 수 있는 해쉬(왜냐면 공백이라도 들어가면 값이 아예 달라지기 때문)
	 * 
	 * $ 해쉬를 사용하는 알고리즘은 순서(인덱스)가 없다
	 * 
	 * # MD5 (약함)
	 * 
	 * hello(원래값) -> 5D41402ABC4B2A76B9719D911017C592(생성된 해쉬값)  
	 * hello1 -> 203AD5FFA1D7C650AD681FDFF3965CD2
	 * hello + 공백 -> F814893777BCC2295FFF05F00E508DA6
	 * 
	 * 
	 * # SHA256 (셈)
	 * 
	 * hello -> 2CF24DBA5FB0A30E26E83B2AC5B9E29E1B161E5C1FA7425E73043362938B9824
	 * ...
	 * 
	 * <? extends T>
	 * - 상속관계로 이루어진 클래스만 자료형을 받는다
	 * - ?(자식클래스),T(부모클래스)로 부모클래스와 자식 클래스의 임의의 자료형만 받는다
	 *                                                                                                                
	 * 
	 * */

	public static void main(String[] args) {
		HashSet<Integer> numbers = new HashSet<>();
		//HashSet은 인덱스 없음
		
		numbers.add(100);
		numbers.add(100);
		numbers.add(100);
		numbers.add(100);
		numbers.add(100);
		
		System.out.println(numbers);
		
		//같은 컬렉션 인터페이스이기 때문에 ArrayList에 있는 메서드들이 여기에도 있다
		
		if(numbers.remove(100)) {
			System.out.println("지우기 성공");
		}else {
			System.out.println("지우기 실패");
		}
		System.out.println(numbers);
		
		//이름에 해쉬가 들어간 알고리즘들은 순서가 없다
		HashSet<String> english = new HashSet<>();
		
		english.add("apple");
		english.add("airplane");
		english.add("bio");
		english.add("cat");
		english.add("drama");
		english.add("zebra");
		
		System.out.println(english);
		
		//Set은 인덱스가 없기 때문에 for-each만 사용할 수 있다
		for (String word : english) {
			System.out.println(word);
		}
		
		//컬렉션끼리는 변환이 자유롭다
		//set의 내용을 정렬해야 한다면 List로 변환하여 사용할 수 있다
		//List의 내용들 중 중복을 제거한 목록이 필요하다면 set으로 변환하여 사용할 수 있다
		ArrayList<String> english_list = new ArrayList<>(english);
		Collections.sort(english_list);   //english는 String이니까 넣은 순서대로 정렬이 되겠지
		System.out.println(english_list);
		
												//<>얘는 그냥  제네릭 쓰고 있다는 표시 정도
		ArrayList<Integer> numbers2 = new ArrayList<>();  //Collection<? extends Integer>는?
		  									//new ArrayList<>()에서 ()들어가는 타입이 Collection이고
											//제네릭 타입은 Integer와 Integer의 자식까지 들어갈 수 있다 그런 뜻
		
		numbers2.add(1);
		numbers2.add(1);
		numbers2.add(1);
		numbers2.add(3);
		numbers2.add(6);
		numbers2.add(6);
		numbers2.add(6);
		numbers2.add(13);
		
		System.out.println(numbers2);
		System.out.println(new HashSet<>(numbers2));
	
		//컬렉션들을 배열로 변환하기
		//Object와 String은 상속 관계가 맞지만
		//Object[]과 String[]은 상속 관계가 아니다.배열은 배열일 뿐
		Object[] arr1 = english.toArray();  //1번 방법, Object[]을 생성
						//해쉬셋타입인 english를 toArray()으로 Array 타입으로 바꾸기
		//.toArray() Method의 경우, Object array를 리턴합니다.
		//이럴 경우, 적절히 타입 캐스팅을 해서 사용을 해야 하는 번거로움이 있다
		
		String[] arr2 = new String[english.size()]; //2번 방법, 미리 만들어둔 배열을 전달
		english.toArray(arr2);
		//이거는 toArray(T[] a)으로 리턴될 array의 타입을 지정해서 타입 캐스팅을 안할 수 있도록
		
		System.out.println("object[]로 변환된 english : " + Arrays.toString(arr1));
		System.out.println("배열로 변환된 english : " + Arrays.toString(arr2));
		
		
		//제네릭을 요구하는 클래스에 제네릭을 사용하지 않는 경우 모든 타입을 넣을 수 있다
		//모든 타입이 Object 타입으로 업캐스팅되어 저장된다
		//해당 값을 다시 제대로 사용하기 위해서는 다운 캐스팅이 필요해서 번거롭다
	
		ArrayList numbers3 = new ArrayList();
		
		numbers3.add("홍길동");
		numbers3.add('A');
		numbers3.add(123.123);
		numbers3.add(333);
		
		//String str = (String)numbers3.get(3); //자바 문법상으로는 아무 문제 없지만 에러
//		int str = (int)numbers3.get(3); //자바 문법상으로는 아무 문제 없지만 에러
//		String strnum = "" + str;
				// 3번 인덱스를 string으로 바꾸고 싶다면 먼저 object -> int로 변환하고 int -> string으로 변환해야할 것
		
		//contains(value) : 컬렉션에 해당 요소가 포함되어 있는지 여부 반환
		System.out.println(english.contains("apple"));
		System.out.println(english.contains("banana"));
		
		System.out.println(english_list.contains("apple"));
		System.out.println(english_list.contains("banana"));
		
		// containsAll(Collection) : 전달한 컬렉션이 모두 포함되어 있는지를 검사
		Set<String> subset = new HashSet<>();
		List<String> sublist = new ArrayList<>();
		
		subset.add("zebra");
		subset.add("drama");
		subset.add("tiger");
		
		sublist.add("apple");
		sublist.add("apple");
		sublist.add("apple");
		
		System.out.println("english에는 subset의 모든 내용이 들어있나요?" + 
					english.containsAll(subset));
		System.out.println("english에는 sublist의 모든 내용이 들어있나요?" + 
				english.containsAll(sublist));
		
		//addAll(Collection) : 전달한 컬렉션의 내용을 모두 추가 
		//새로 추가된 것이 있으면 true
		//이미 모두 포함된 경우에는 false를 반환한다
		System.out.println(english.addAll(subset));
		System.out.println(english.addAll(subset));
	
		//removeAll(Collection) : 전달한 컬렉션과 같은 내용을 모두 제거
		// 지워진게 있으면 true 없으면 false
		System.out.println(english_list.removeAll(subset));
		System.out.println(english_list);
		
		//retainAll(Collrection) : 전달한 컬렉션과 일치한 내용만 남긴다
		// 변한 것이 있다면 true 없으면 false
		english.retainAll(subset);
		System.out.println(english);
		
		//isEmpty() : 해당 컬렉션이 비어 있으면 true
		System.out.println(english.isEmpty());
		System.out.println(!english.isEmpty());
	}
	
}































