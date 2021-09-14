
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;  //Map인터페이스에 Entry 이너 인터페이스가 있다

public class D07_HashMap {
	
	/*
	 * Map
	 * 
	 * -key와 value가 한쌍을 이루는 자료구조
	 * -key값을 통해 value에 접근할 수 있다
	 * -key는 중복을 허용하지 않는다
	 * 
	 * */
	public static void main(String[] args) {
		
		HashMap<String, Integer> record = new HashMap<>();
		
		//put(key,value) : 
		// -map에 데이터 추가
		// -예전에 들어있던 값이 있으면 그 값을 리턴, 없으면 null을 리턴
		 record.put("홍길동",50000);
		 record.put("고길동",35000);
		 record.put("박길동",90000);
		 
		 //이미 존재하는 키값에 put하면 값을 수정
		Integer previous_value = record.put("홍길동",3500); 
		 
		System.out.println("이전에 들어있던 값: " + previous_value);
		System.out.println("지금 들어있는 값: " + record.get("홍길동"));  
		
		 record.put("홍길동",record.get("홍길동") + 3000);
		 
		 System.out.println(record);
		 
		 //get(key) : key를 이용해서 value를 꺼냄
		 System.out.println(record.get("박길동"));
		 
		 HashMap<String, Object> person = new HashMap<>();
		 
		 person.put("이름", "홍길동");
		 person.put("나이", 35);
		 person.put("좋아하는 것", new String[] {"놀기","잠자기","먹기"});
		 person.put("싫어하는 것",new HashSet<>());
		 
		 //containsKey(key) : 맵에 해당 키가 포함되어 있는지 검사한다
		 System.out.println(person.containsKey("이름"));
		 
		 //containsValue(Value) : 맵에 해당 값이 포함되어 있는지 검사한다
		 System.out.println(person.containsValue("홍길동"));
		 
		 
		 //연습문제 : "싫어하는 것"에 데이터를 추가해라
		 //add를 쓸려면 object에서 hashset으로 다운캐스팅을 해줘야한다.업캐스팅이 되어 있는 상태에선
		 //자식이 가지고 있던 것을 쓸 수 없기 때문
		 HashSet<String> dislike = ((HashSet<String>) person.get("싫어하는 것"));
		 
		 dislike.add("야근");
		 dislike.add("퇴근");
		 dislike.add("출근");
		 
		 ((HashSet<String>) person.get("싫어하는 것")).add("피곤한거"); 
		 
		 System.out.println(person.get("나이"));
		 //업캐스팅되면 자신이 가지고 있던 것을 못쓴다. 기능 쓸때는 다운 캐스팅 필요
		 System.out.println(((String[]) person.get("좋아하는 것"))[0]);
		 System.out.println(person.get("싫어하는 것"));
	
		 /* 
		  * 반복문으로 Map을 활용하기
		  * 
		  * -keySet() : key들로만 이루어진 Set을 반환
		  * -values() : value들로만 이루어진 Set을 반환
		  * -entrySet() : Entry<key,value>로 이루어진 Set을 반환
		  * 
		  */
		 
		 for(String key : person.keySet()) {
			 Object value = person.get(key);
			 
			 //A instanceof B : A가 B의 인스턴스인지를 판별한다.업캐스팅 상태에서도 판별된다
			 if(value instanceof String[]) {
				 System.out.print(key + ": [");

				 String[] arr = (String[])value;
				 
				 for (int i = 0; i < arr.length; ++i) {
					 System.out.print(arr[i] + ", ");
				 }
				 System.out.println("]");
			 }else {
				 System.out.println(key + ": " + value);
			 }
		 }
	
		 //values()
		 System.out.println("values : " + person.values());
	
		 //entrySet()
		 //Entry - 인터페이스
		 // -엔트리는 키랑 값을 묶음으로 가져오는 거
		 for (Entry<String, Object> entry : person.entrySet()) {
			 String key = entry.getKey();
			 Object value = entry.getValue();
			 
			 System.out.println(key + "=" + value);
		 }
	
	}
}


































