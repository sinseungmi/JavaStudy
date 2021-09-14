package qiuz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class D02_LottoSet {
	/*
	 * 1부터 45 사이의 중복 없는 랜덤 숫자 7개로 이루어진 HashSet을 생성하여 
	 * 반환하는 메서드를 작성 후 테스트해보기
	 * 
	 * */
	
	//Integer.parseInt : String을 int로 변환 하는 것
						//제네릭 쓰는 거 잊지말기
	public HashSet<Integer> getLottoSet() {
		HashSet<Integer> lotto = new HashSet<>(); 
		
		while(lotto.size() < 7) {
			lotto.add((int)(Math.random() * 45) + 1);
		}
		return lotto;
	}
	
	/*
	 * 1부터 45 사이의 중복 없는 랜덤 숫자 7개로 이루어진 ArrayList를 생성하여 
	 * 반환하는 메서드를 작성 후 테스트해보기
	 * 
	 * */
	public ArrayList<Integer> getLottoList(){
		return new ArrayList<>(getLottoSet());
	}
	
	/*
	 * 1부터 45 사이의 중복 없는 랜덤 숫자 7개로 이루어진 int[]를 생성하여 
	 * 반환하는 메서드를 작성 후 테스트해보기
	 * 
	 * */
	public Integer[] getLottoArray() {
		return getLottoList().toArray(new Integer[7]);  //리스트 내용물들을 여기(new Integer[7]) 다 담아주세요~~
	}				//array로 만들려면 어떤 타입인지,사이즈는 얼마나 되는지 알아야겠디
	
	public int[] getLottoArray2() {
		Integer[] lotto = getLottoArray();
		int[] result = new int[7];
		
		for (int i = 0; i < 7; i++) {
			result[i] = lotto[i];
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		HashSet<Integer> lotto = new D02_LottoSet().getLottoSet();
								//클래스 인스턴스를 생성하고 getLottoSet() 메서드를 불러온다
		System.out.println(lotto);
	}

}



























