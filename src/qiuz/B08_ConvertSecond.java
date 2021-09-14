package qiuz;

import java.util.Scanner;

public class B08_ConvertSecond {

	public static void main(String[] args) {
		/*
		 * 초를 입력 받으면 년/일/시간/분/초로 변환하여 출력해보세요
		 * 
		 * 필요없는 단위는 출력하지 말것 ex : 0년 0일 5시간 0분 20초인 경우 0년 0일은 나오지 않아야 함
		 *
		 */
		
		final int SECOND_PER_YRER = 60 * 60 * 24 * 365;
		final int SECOND_PER_DAY = 60 * 60 * 24;
		final int SECOND_PER_HOUR = 60 * 60;
		final int SECOND_PER_MINUTE = 60;
		
		int second = new Scanner(System.in).nextInt();
		int secondTemp = second;
		int year, day, hour, minute;
		
		year = second / SECOND_PER_YRER;
		second %= SECOND_PER_YRER;
		day = second / SECOND_PER_DAY;
		second %= SECOND_PER_DAY;
		hour = second / SECOND_PER_HOUR;
		second %= SECOND_PER_HOUR;
		minute = second / SECOND_PER_MINUTE;
		second %= SECOND_PER_MINUTE;
		
		boolean bool = false;
		
		System.out.println(secondTemp + "초에 계산 결과");
		
		if (year != 0) { 
			System.out.print(year + "년 ");
			bool = true;
		}
		if (bool || day != 0) {
			System.out.print(day + "일 ");
			bool = true;
		}
		if (bool || hour != 0) {
			System.out.print(hour + "시간 ");
			bool = true;
		}
		if (bool || day != 0) {
			System.out.print(minute + "분 ");
			bool = true;
		}
		System.out.println(second + "초");
		
		
//		int second = new Scanner(System.in).nextInt();
//		
//		int year, day, hour, minute;
//		
//		boolean bool = false;
//		
//		year = 60 * 60 * 24 * 365;
//		day = 60 * 60 * 24;
//		hour = 60 * 60;
//		minute = 60;
//		
//		int second_Per_Year = second / year;
//		second %= year;
//		int second_Per_Day = second / day;
//		second %= day;
//		int second_Per_hour = second / hour;
//		second %= hour;
//		int second_Per_minute = second / minute;
//		second %= minute;
//		
//		if (second_Per_Year != 0) {
//			System.out.print(second_Per_Year + "년");
//			bool = true;
//		}
//		if (bool || second_Per_Day != 0) {
//			System.out.print(second_Per_Day + "일");
//			bool = true;
//		}
//		if (bool || second_Per_hour != 0) {
//			System.out.print(second_Per_hour + "시간");
//			bool = true;
//		}
//		if (bool || second_Per_minute != 0) {
//			System.out.print(second_Per_minute + "분");
//		}
//		System.out.println(second + "초");
		
//		* 1년 : 60 * 60 * 24 * 365 초
//		 * 1일 : 60 * 60 * 24 초
//		 * 1시간 : 60 * 60 초
//		 * 1분 : 60 초
//		System.out.print("초를 입력하세요 : ");
//		int second = new Scanner(System.in).nextInt();
//		
//		final int SECOND_PER_YEAR = 60 * 60 * 24 * 365;
//		final int SECOND_PER_DAY = 60 * 60 * 24;
//		final int SECOND_PER_HOUR = 60 * 60;
//		final int SECOND_PER_MINUTE = 60;
//	
//		int year, day, hour, minute, seconTemp;
//		boolean bool = false;
//
//		seconTemp = second;
//		year = second / SECOND_PER_YEAR;
//		second %= SECOND_PER_YEAR;
//		day = second / SECOND_PER_DAY;
//		second %= SECOND_PER_DAY;
//		hour = second / SECOND_PER_HOUR;
//		second %= SECOND_PER_HOUR;
//		minute = second / SECOND_PER_MINUTE;
//		second %= SECOND_PER_MINUTE;
//
//		//System.out.printf("%d년/%d일/%d시간/%d분/%d초", year, day, hour, minute, second);
//		System.out.printf("%d초 환산은 ?\n", seconTemp);
//
//		if (year != 0) {
//			System.out.print(year + "년/");
//			bool = true;
//		}
//		if (day != 0 || bool) {
//			System.out.print(day + "일/");
//			bool = true;
//		}
//		if (hour != 0 || bool) {
//			System.out.print(hour + "시간/");
//			bool = true;
//		}
//		if (minute != 0 || bool) {
//			System.out.print(minute + "분/");
//			bool = true;
//		}
//		System.out.print(second + "초");


	}

}
