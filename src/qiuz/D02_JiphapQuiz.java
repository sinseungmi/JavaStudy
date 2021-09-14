package qiuz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.type.IntersectionType;

/*                 
	1. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 합집합을 Set타입으로 반환하는 메서드
	
	2. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 교집합을 Set타입으로 반환하는 메서드
	
	3. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 차집합을 Set타입으로 반환하는 메서드
*/


/*public class D02_JiphapQuiz{
	
	public Set union(Collection a, Collection b) {
		
		Set hap = new HashSet(a);
		hap.addAll(b);    //hap(a)에 b를 전부 추가한다
		return hap;
	}
	
	public Set intersection(Collection a, Collection b) {
		
		Set hap = new HashSet(a);
		hap.retainAll(b);    
		return hap;
	}
	
	public Set diff(Collection a, Collection b) {
		
		Set hap = new HashSet(a);
		hap.removeAll(b);    
		return hap;
	}
	
	public static void main(String[] args) {
		HashSet<String> animal = new HashSet<>();
		ArrayList<String> animal2 = new ArrayList<>();
		
		animal.add("기린");
		animal.add("사슴");
		animal.add("햄스터");
		animal.add("호랑이");
		animal.add("강아지");
		animal.add("고양이");
		
		animal2.add("악어");
		animal2.add("곰");
		animal2.add("펭수");
		animal2.add("다람쥐");
		animal2.add("호랑이");
		animal2.add("기린");
		
		D02_JiphapQuiz q = new D02_JiphapQuiz();
		
		System.out.println(q.union(animal,animal2));
		System.out.println(q.intersection(animal,animal2));
		System.out.println(q.diff(animal,animal2));
	}	
	
}*/


//제네릭을 설정해둔 클래스는 인스턴스 생성시 원하는 타입을 고를 수 있게 된다
//고르지 않으면 object로 설정된다
//static에는 제네릭을 사용할 수 없다(T는 인스턴스변수로 간주되기 때문)
public class D02_JiphapQuiz<T> {
	
			//모든 타입의 매개변수를 받기위해서라면 제네릭 안받아야함
	public Collection<T> union(Collection<T> a, Collection<T> b){
//		Set<T> union_set = new HashSet<T>(a);
		a.addAll(b);
		return a;
	}
	
	public Set<T> intersection(Collection<T> a, Collection<T> b){
		Set<T> inter_set = new HashSet<>(a);
		inter_set.retainAll(b);
		return inter_set;
	}
	
	// A - B
	// B - A
	public Set<T> diff(Collection<T> a, Collection<T> b){
		Set<T> diff_set = new HashSet<>(a);
		diff_set.removeAll(b);
		return diff_set;
	}
	
	public static int plus(int a, int b) {
		a += b;
		return a;
	}
	
	public static String plusStr(String a, String b) {
		//String은 값을 변화시킬 수 없다.
		//+=을 할 때 알아서 새로운 String 인스턴스를 생성하도록 설계되어 있다
		//왜? String안에 설계되어 있는 배열이 final이기 때문이다(final은 바꿀 수 없다는 것을 명심)
		
		a += b;
		return a;
	}
	

	public static void main(String[] args) {
		//소문자로 시작하는 타입들(기본형)은 매개변수로 전달할 때 값을 복사하여 전달한다
		int int_a = 20;
		int int_b = 30;
		
		System.out.println(plus(int_a, int_b));
		System.out.println("plus 후 int_a의 값 : " + int_a);
		
		//대문자로 시작하는 타입들(참조형)은 매개변수로 전달할 때 주소를 복사하여 전달한다
		D02_JiphapQuiz<Integer> jip = new D02_JiphapQuiz<Integer>();
		HashSet<Integer> twoDan = new HashSet<>();
		
		twoDan.add(2);
		twoDan.add(4);
		twoDan.add(6);
		twoDan.add(8);
		twoDan.add(12);
		twoDan.add(18);
		
		ArrayList<Integer> threeDan = new ArrayList<>();
		
		threeDan.add(3);
		threeDan.add(6);
		threeDan.add(9);
		threeDan.add(12);
		threeDan.add(15);
		threeDan.add(18);
		
		ArrayList<Integer> fourDan = new ArrayList<>();
		
		fourDan.add(4);
		fourDan.add(8);
		fourDan.add(16);
		fourDan.add(20);
		
		System.out.println("\nunion을 실행하기 전의 twoDan: " + twoDan);
		System.out.println(jip.union(twoDan,threeDan));
	
		System.out.println("\nunion을 실행하기 후의 twoDan: " + twoDan);
		System.out.println(jip.union(twoDan,fourDan));
		
		System.out.println(jip.intersection(jip.intersection(twoDan,threeDan),fourDan));
	}


}
