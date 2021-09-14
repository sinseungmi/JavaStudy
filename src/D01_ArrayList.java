import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class D01_ArrayList {
	
	/*
	 * # JAVA Collections
	 * - 자바에서 기본적으로 제공하는(Built In) 자료구조 인터페이스 
	 * - Collections 인터페이스를 상속받은 인터페이스로는 List,Set이 있다
	 * 
	 * # java.util.ArrayList
	 * - 배열과 다르게 크기가 자동으로 조절되는 자료구조 클래스
	 * - 배열과 유사한 형태이다
	 * - 순차적으로 모든 데이터에 접근해야할 때 가장 유리하다
	 * 
	 * */
	public static void main(String[] args) {
		
		//타입을 지정하며 ArrayList 생성하기
		// - 타입을 지정할 때 사용하는 <>를 제네릭(Generic)이라고 부른다
		// - 제네릭에는 기본형 타입을 사용할 수 없다 (기본 타입의 WrapperClass 이용)
		ArrayList<String> fruits = new ArrayList<>();
		ArrayList<Integer> numbers = new ArrayList<>();
		
		//add(item): 리스트에 원하는 데이터를 순차적으로 맨뒤에 추가한다
		fruits.add("apple");
		fruits.add("kiwi");
		fruits.add("apple");
		fruits.add("apple");
		fruits.add("kiwi");
		
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(40);
		
		//add(index,item): 리스트의 원하는 위치에 데이터를 넣는다
		fruits.add(2,"orange");
		fruits.add(2,"peach");
		fruits.add(2,"grape");
		
		System.out.println(numbers);
		System.out.println(fruits);
		
		//get(index): 리스트에서 원하는 인덱스의 데이터를 하나 꺼낸다
		System.out.println(fruits.get(0));
		System.out.println(fruits.get(1));
		System.out.println(fruits.get(2));
		System.out.println(fruits.get(3));
		
		//size() : 해당 컬렉션의 크기를 반환한다
		System.out.println("fruits의 크기" + fruits.size());
		System.out.println("numbers의 크기" + numbers.size());
		
		//remove(index): 해당 번째의 데이터를 삭제한다. 방금 지운 데이터를 반환한다
		String deleted_fruits = fruits.remove(3);
		numbers.remove(2);
		
		System.out.println("삭제후 " + fruits);
		System.out.println("삭제된 것 " + deleted_fruits);
		
		//remove(item):해당 데이터를 삭제한다. 삭제 성공 여부 반환
		if(fruits.remove("strawberry")) {
			System.out.println("strawberryd를 성공적으로 삭제");
		}else {
			System.out.println("strawberry가 없어서 삭제 못함");
		}
		
		//정렬
		Collections.sort(fruits);
		System.out.println(fruits);
		
		//배열 정렬(오름차순)
		int[] lottos = {45,1,7,13,8,20,11};
		Arrays.sort(lottos);
		System.out.println(Arrays.toString(lottos));
	}
}

























