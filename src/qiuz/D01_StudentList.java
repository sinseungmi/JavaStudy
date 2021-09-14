package qiuz;

import java.util.ArrayList;

import myobj.student.Student;

public class D01_StudentList {
	
	/*
	 * 학생 클래스를 요소로 갖는 ArrayList를 생성하고 학생을 30명 추가해라
	 * 
	 * 1. 각 학생의 점수는 랜덤으로 설정됩니다
	 * 2. 과목은 국/영/수 밖에 없음
	 * 3. 30명의 평균을 출력해라
	 * 4. 30명 중 가장 총점이 높은 학생의 이름과 성적을 출력해달라
	 * 5. 이름은 다음과 같이 생성됩니다
	 * 
	 * 		학생000000
	 * 		학생000001
	 * 		학생000002
	 * 		..
	 * 
	 * */
	
	
	public static void main(String[] args) {
		ArrayList<Student> studeList = new ArrayList<>();
		int firstInClass = 0;
		
		for(int i = 0; i < 30; i++) {
			Student stu = new Student();
			studeList.add(stu);
			System.out.println(stu.toName() + "의 평균 : " + studeList.get(i).average());
			firstInClass = Math.max(studeList.get(i).getSum(), firstInClass);
//			System.out.println(".");
		}

		for (int i = 0; i < 30; i++) {
			if (firstInClass == studeList.get(i).getSum()) {
				System.out.println("총점 : " + firstInClass);
				studeList.get(i).studentOutput();
			}
			
		}
		
	}

}












