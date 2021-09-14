# JavaStudy

------------------------

## Escape 문자
 - 앞에 \(역슬래시)가 붙은 문자는 Escape 문자로 간주한다
 - \n, \t, \\\, \\", \\' ..

## 변수 (variable)
 - 데이터를 담을 수 있는 공간
 - 타입은 int, long, String, boolean, float, double, 참조형 .. 등이 있다  
 ex) 타입 변수명;
 
## 연산자 (Operator) 
 - +, -, *, /, %    
 - [ Math 클래스 ]
   - Math.pow(대상 숫자, 거듭제곱 횟수) : 제곱 구하기  
   - Math.sqrt(16) : 제곱근 구하기
   - Math.round(3.35) : 반올림
   - Math.ceil(3.35)  : 올림
   - Math.floor(3.35) : 내림
   - Math.max(1900, 1500) : 큰 숫자 추출
   - Math.min(1900, 1500) : 작은 숫자 추출

##### 1] 비교 연산자
 - 비교 연산의 결과는 참 또는 거짓이다(boolean 타입이다)
 - 산술 연산과 비교 연산이 함께 있으면 산술 연산을 먼저 계산한다
 - &#62;, <, >=, <=, ==, !=

##### 2] 논리 연산자
 - boolean 타입 값으로 하는 연산
 - && : 양 옆의 값이 모두 true일 때만 true(AND)
 - || : 양 옆의 값 중 하나만 true여도 true(OR)
 - ! : true면 false, false면 true (NOT)

##### 3] 삼항 연산자
 - 간단한 if문을 한줄로 표현할 수 있다
 - 조건 ? 예 : 아니오;

## If문
 - 조건문이 true일 땐 실행, false일 때는 생략
 - else if문 - 여러 조건문이 필요하실에 사용(단독 사용 X)
 - else문 - if, else if 모두 false일 때 실행
 
## 반복문
   ##### - for문
  for (초기화; 조건; 증감값){
		 가운데 있는 조건이 true인 동안 반복될 명령어들을 적는 곳
		}












   
