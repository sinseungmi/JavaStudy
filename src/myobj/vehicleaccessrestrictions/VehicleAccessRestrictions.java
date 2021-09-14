package myobj.vehicleaccessrestrictions;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class VehicleAccessRestrictions{
	//정규표현식해보기..올바른 차량번호인지 거르고 끝번호는 0~9까지 반복문 돌려서 거르기
	//랜덤으로 여러값 넣어서 테스트
	Car car;
	
	public VehicleAccessRestrictions(int vehicleNumber, String Excludedvehicles) {
		car = new Car(vehicleNumber,Excludedvehicles);
	}
	
	public boolean equalCar(String Excludedvehicles) {
		if ("경차".equals(Excludedvehicles) 
			|| "장애인".equals(Excludedvehicles) 
			|| "유아동승".equals(Excludedvehicles)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public int endCarNumber(int vehicleNumber) {
		
		String vehicleStr = "" + vehicleNumber;
		
		if (vehicleStr.length() != 4) {
			System.out.println("차량번호 길이가 맞지않습니다. 다시 입력하세요");
			return -1;
		}
		
		return vehicleStr.charAt(3) - '0';
	}
	
	public boolean vehicleNumberInspection() {
		
		Calendar korea = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
		korea.set(2021, 3, 19);
		
		LocalDate currentDate = korea.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate limitedDate = LocalDate.of(2018, 9, 1);
		
		if(currentDate.isBefore(limitedDate)) {
			System.out.println(currentDate.format(
					DateTimeFormatter.ofPattern("y년 M월 d일")) + "은 차량제한이 시행되기 이전입니다");
			return false;
		}
		
		int whatDay = korea.get(Calendar.DAY_OF_WEEK);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 d일 EEEE");
		String today = sdf.format(korea.getTime());
		
		String[] todayArray = today.split(" ");  //문자열 
		String day_of_the_week = todayArray[3];  //나타낼라고
		int[] carDigit = passedVehicle(whatDay); //만든 것들
		int firstNum = 1, endNum = 6;
		
		int carEndNum = endCarNumber(car.getVehicleNumber());
	
		if (whatDay == Calendar.SUNDAY || whatDay == Calendar.SATURDAY) {
			System.out.println("주말은 모든 차량 출입 가능"); 
			return true;
		}
		
		for (int i = 2; i <= 5; i++) {
			String Excludedvehicles = car.getExcludedvehicles();
			String text = String.format("오늘은 %s 입니다. %s은 %d,%d 출입이 가능하며, "
					+ "해당 차종의 끝번호는 %d이므로 출입이 제한됩니다",
					today, day_of_the_week, carDigit[0], carDigit[1], carEndNum);
		
			if (carEndNum == -1) return false;
			
			if(equalCar(Excludedvehicles)) {
				System.out.println(Excludedvehicles + "는(은) 제한없이 출입 가능합니다");
				return true;
			}else if (whatDay == i && carEndNum != firstNum && carEndNum != endNum) {
				System.out.println(text); 
				return false;
			}
			
			firstNum++;
			endNum++;
			
			if(whatDay == Calendar.FRIDAY && carEndNum != 5 && carEndNum != 0) {
				System.out.println(text);
				return false;
			}
		}
		
		System.out.printf("오늘은 %s 입니다. %s은 %d,%d출입이 가능하며,"
				+ " 해당 차량 끝번호는 %d이므로 통과되었습니다.",
				today, day_of_the_week, carDigit[0], carDigit[1], carEndNum);
		return true;

	}
	
	public int[] passedVehicle(int whatDay) {
		int[] carDigit = new int[2];
		switch(whatDay) {
		case 2:
			carDigit[0] = 1; carDigit[1] = 6; break;
		case 3:
			carDigit[0] = 2; carDigit[1] = 7; break;
		case 4:
			carDigit[0] = 3; carDigit[1] = 8; break; 
		case 5:
			carDigit[0] = 4; carDigit[1] = 9; break; 
		case 6:
			carDigit[0] = 5; carDigit[1] = 0; break;
		}
		
		return carDigit;
	}


	public static void main(String[] args) {
		VehicleAccessRestrictions var = new VehicleAccessRestrictions(9050, "유아승");
		var.vehicleNumberInspection();

	}

}




















