package qiuz;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class D07_PhoneBook {
	
	/*
	 * # HashMap을 이용해 전화번호부를 구현해보세요
                 
       1. 그룹 / 전화번호 / 이름을 저장해야 한다
       2. 그룹 이름을 키값으로 넣으면 해당 그룹의 전화번호 목록이 나온다
       3. 전화번호 목록에 전화번호를 키값으로 넣으면 이름이 나온다
                 
       # 구현해야 할 메서드
                 
       1. 새로운 그룹을 추가하는 메서드 
       2. 존재하는 그룹에 새로운 전화번호를 등록하는 메서드 (그룹이 없다면 미분류 그룹에 저장) 
       3. 등록된 모든 전화번호부 정보를 이름기준 오름차순으로 보여주는 메서드
       4. 이름의 일부를 입력하면 일치하는 모든 정보가 출력되는 검색 메서드 
       5. 전화번호의 일부를 입력하면 일치하는 모든 전화번호가 출력되는 검색 메서드  

	 * 
	 * */
	//입력은 메인에서!!
	//입력과 처리와 화면을 구분
	//메서드는 불러서 가져다 쓰는거임 안에서 입력 받으면 안됨
	//key에 번호를 넣는 이유는 중복 값이 들어가면 안되기 때문
	
		HashMap<String, HashMap<String, String>> phone_book;
		HashMap<String, String> keep;
		
		public D07_PhoneBook() {
			phone_book = new HashMap<>();
			
			phone_book.put("가족", new HashMap<>());
			phone_book.put("미분류", new HashMap<>());
		}
		
		public void existing_group(String group_name, String number, String name) {
			//System.out.print("기존 그룹 이름 입력 : ");
			for (HashMap<String, String> value : phone_book.values()) {
				if(value.containsValue(number)) {
					System.out.println("이미 저장된 번호입니다");
					break;
				}
			}
			

			if(phone_book.containsKey(group_name)) {
				phone_book.get(group_name).put(number,name);
			}else {
				phone_book.get("미분류").put(number,name);	
			}
		}
		
		public void groupAdd(String groub) {
			//System.out.print("새로운 그룹 이름 입력 : ");
			if(phone_book.containsKey(groub)) {
				System.out.printf("이미 등록된 그룹입니다(%s)", groub);
			}else {
				phone_book.put(groub, new HashMap<>());
				System.out.println("그룹이 등록되었습니다");
			}
		}
		
		public void nameAlignment() {  //트리셋은 중복제거되는 것을 조심
			
			TreeSet<Entry<String, String>> sortedByName = new TreeSet<>(
					new Comparator<Entry<String, String>>() {

						@Override
						public int compare(Entry<String, String> o1, Entry<String, String> o2) {
							int return_value = o1.getValue().compareTo(o2.getValue());
							
							if (return_value == 0) {
								return o1.getKey().compareTo(o1.getKey());
							}else {
								return return_value;
							}
						}
					});

			//System.out.println(phone_book.values());
			Collection<HashMap<String, String>> phone_list= (Collection<HashMap<String, String>>) phone_book.values();
			
			for (HashMap<String, String> phone_info : phone_list) {
				sortedByName.addAll(phone_info.entrySet());
			}
			
			System.out.println(sortedByName);

			/* keep = (HashMap<String, String>) phone_book.values();
			TreeSet<String> align_name = new TreeSet<>();
			for(String key : keep.keySet()) {
				align_name.add(keep.get(key));
			}
			LinkedList<String> reverse = (LinkedList<String>) align_name.descendingSet();
			
			for (int i = 0; i < reverse.size(); i++) {
				String popName = reverse.pop();
				System.out.println(keep.get(popName));
			}*/
		}
		
		void name_search(String search) {
			System.out.println("이름 검색 : ");
			int count = 0;
			
			System.out.printf("검색 결과 %d건 : ",count);
	
		}
		public void searchByName(String keyword) {
			System.out.println("전화번호 검색 : ");
			int count = 0;
			
			System.out.printf("검색 결과 %d건 : ",count);	
		}
	

		public static void main(String[] args) {
			D07_PhoneBook book = new D07_PhoneBook();
			
			Scanner sc = new Scanner(System.in);
			
			book.existing_group("가족","010-7349-0555","신승미");
			book.existing_group("미분류","010-5649-0555","조연주");
			book.existing_group("미분류","010-4349-0555","홍지유");
			book.existing_group("가족","010-0849-0465","이남희");
			
			book.nameAlignment();
			
		}
		
		
		 
	
		
	
	
	
	
	
	
	
	
	
	

}












