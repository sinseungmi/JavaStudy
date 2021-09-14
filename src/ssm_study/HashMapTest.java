package ssm_study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapTest {

	public static void main(String[] args) {
		String[] arr = new String[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = String.format("안녕%d", i);
		}
		System.out.println(arr.toString());
		System.out.println("배열" + Arrays.toString(arr));  //배열은 Arrays.toString()으로 값을 볼 수 있다
		
		HashMap<String, Integer> map = new HashMap();
		for(int i = 0; i < 10; i++) {
			map.put(String.format("안녕%d",i), i);
		}
		System.out.println(map);
		
		for(Entry<String, Integer> set : map.entrySet()) {
			String key = set.getKey();
			int value = set.getValue();
			System.out.println(key + " : " + value);
		}

	}

}





