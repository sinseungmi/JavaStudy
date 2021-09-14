package qiuz;

import java.lang.reflect.Array;
import java.util.Arrays;

public class B18_Array2Quiz {

	public static void main(String[] args) {
		
		int[][] numArr = new int[][]{
			{1 ,1 ,1 ,1},
			{1 ,1 ,1 ,1, 1, 1, 1},
			{1 ,1 ,1 ,1, 1, 1},
			{1 ,1 },
			{1 ,1 ,1 ,1, 1},
			
		};
		
		//1. numArr의 모든 값을  0 ~ 100 사이의 랜덤 정수로 바꿔보세요
		
		//2. numArr의 총합과 평균(소수점 둘째 자리까지)을 구해서 출력해보세요
		
		//3. numArr의 각 행의 합을 모두 구해서 출력해보세요

		//4. numArr의 각 열의 합을 모두 구해서 출력해보세요
		
		int sum = 0;
		double aver = 0;
		int people = 0;
		for (int i = 0; i < numArr.length; i++) {
			people += numArr[i].length;
			for (int j = 0; j < numArr[i].length; j++) {
				numArr[i][j] = (int)(Math.random() * 101);
				//System.out.println(numArr[i][j]);
				sum += numArr[i][j];
			}
		}
		aver = (double)sum / people;
		System.out.println(sum + "," + aver);
		
		int[] rowSum = new int[numArr.length]; 
		int longer = 0;
		
		for (int i = 0; i < numArr.length; i++) {
			for(int j = 0; j < numArr[i].length; j++) {
				rowSum[i] += numArr[i][j]; 
			}
		}
		System.out.println(Arrays.toString(rowSum));
		
		for (int i = 0; i < numArr.length; i++) {
			longer = Math.max(longer, numArr[i].length);
		}
		int[] column = new int[longer];
		
		for (int i = 0; i < numArr.length; i++) {
			for(int j = 0; j < numArr[i].length; j++) {
				column[j] += numArr[i][j]; 
			}
		}
		System.out.println(Arrays.toString(column));
		
		
		
		
//		int[] lineSum = new int[numArr.length];
//		int sum = 0;
//		double aver = 0;
//		int people = 0;
//		
//		for (int i = 0; i < numArr.length; i++) {
//			people += numArr[i].length;
//			for (int j = 0; j < numArr[i].length; j++) {
//				numArr[i][j] = (int)(Math.random() * 101);
//				sum += numArr[i][j];
//				
//				lineSum[i] += numArr[i][j];
//			}
//		}
//		
//		aver = sum / (double)people;
//		System.out.printf("총합 : %d점, 평균 : %.2f점\n",sum,aver);
//		
//		for (int i = 0; i < lineSum.length; i++) {
//			System.out.printf("%d번째 줄 합 : %d점\n", i + 1, lineSum[i]);
//		}
//		
//		// row : 행, column : 열
//		
//		//제일 긴 배열 찾기
//		int longest = 0;
//		for (int i = 0; i < numArr.length; i++) {
//			longest = Math.max(numArr[i].length, longest);
//		}
//		int[] columnSum = new int[longest];//위에 긴 배열을 찾아 longest에 변수에 담고 배열 크기를 정해 놓으면 
//										//바로 아래에서 for문을 돌려도 데이터가 안들어간 값은 초기값 0으로 설정되어 있기 때문에 
//										//더해도 무방하다.배열 크기를 미리 정하면 초기값이 들어있어서 에러 안남
//		
//		for (int i = 0; i < numArr.length; i++) {
//			for (int j = 0; j < numArr[i].length; j++) {
//				columnSum[j] += numArr[i][j];  
//			}
//		}
//		for (int i = 0; i < columnSum.length; i++) {     
//			
//			for (int j = 0; j < numArr.length; j++) {
//				if (numArr[j].length > i) {  
//					columnSum[i] += numArr[j][i];
//				}
//			}
//		}
//
//		// Arrays.toString(): 배열 편하게 출력하기
//		System.out.println("행의 합:" + Arrays.toString(lineSum));
//		System.out.println("열의 합:" + Arrays.toString(columnSum));
	}

}

















