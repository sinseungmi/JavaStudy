import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D09_Regex {

	/*
	 * 정규표현식 (Regular Expression)
	 * 
	 * -문자열의 패턴을 표현하는 표현식
	 * -특정 프로그래밍 언어에 종속되지않는다
	 * -프로그래머가 원하는 문자열 패턴과 일치하는지 검사할 때 사용한다
	 * 
	 *  # pattern 클래스
	 *  -정규표현식을 다루는 클래스
	 *  
	 *  matcher 클래스
	 *  -패턴 인스턴스를 이용하여 문자열을 검사할 때 사용하는 클래스
	 *  
	 * 
	 * */
	public static void main(String[] args) {
		            //검사하는표현식
		//Pattern.matches(regex, input) : input이 regex에 매치되는 문자열인지를 검사해준는 메서드
		System.out.println(Pattern.matches("sleep", "sleep"));
		
		//[] : 해당 위치의 한글자에 어떤 문자들이 올 수 있는지 정의하는 표현식
		System.out.println(Pattern.matches("s[lh@]eep", "slheep"));
		System.out.println(Pattern.matches("s[lh@]eep", "sheep"));
		System.out.println(Pattern.matches("s[lh@]eep", "s@eep"));
		
		/*
		 * [] 내부에 정의할 수 있는 것들 ([]안에들어갈 수 있는건 한글자! 33,44이런건 안됨)
		 * 
		 * 1. abc : 해당자리에 a 또는 b 또는 c
		 * 2. ^abc : 해당자리에 abc를 제외한 모든 것을 허용(공백,\n 이런거 모두 허용)
		 * 3. a-z : a 부터 z까지 모두 허용
		 * 4. &&  : 교집합
		 * 
		 */
		System.out.println(Pattern.matches("s[^lh@]eep", "s eep"));
		System.out.println(Pattern.matches("s[1-9]eep", "s0eep"));
		System.out.println(Pattern.matches("s[0-9a-z]eep", "s0eep"));
											//여러개 정의가능
		System.out.println(Pattern.matches("s[a-d&&c-f]eep", "sceep"));
		System.out.println(Pattern.matches("s[a-d&&c-f]eep", "sfeep"));
	
		/*
		 * 여러문자를 나타내는 것들
		 * 
		 * 1. . : 모든 문자        *[] 밖에 써야 모든 문자
		 * 2. \d : 모든 숫자
		 * 3. \D : 숫자를 제외한 모든 것
		 * 4. \s : 모든 공백(\t,\n ..등의 모든 공백들)
		 * 5. \S : 공백을 제외한 모든 것
		 * 6. \w : 일반적인 문자들을 허용[a-zA-Z0-9_]
		 * 7. \W : 일반적인 문자들을 제외한 모든 것을 허용
		 * 
		 * */
		System.out.println(Pattern.matches("s.eep", "s eep")); //모든 문자
		System.out.println(Pattern.matches("s[.]eep", "s.eep")); //.만 허용
		System.out.println(Pattern.matches("s\\.eep", "sheep")); //.만 허용
		                                  // \\가 두번 들어가는 이유는 이스케잎문으로 읽을 수 있기 때문에!
										  // \n,\t.. 등등!! 
		System.out.println(Pattern.matches("s\\deep", "s99ep"));
		System.out.println(Pattern.matches("\\D\\D\\D", "cat")); 
		
		System.out.println(Pattern.matches("s\\seep", "s eep"));
		System.out.println(Pattern.matches("s\\seep", "saeep"));
		System.out.println(Pattern.matches("s\\seep", "s\teep"));
		System.out.println(Pattern.matches("s\\seep", "s\neep"));
		System.out.println(Pattern.matches("s\\seep", "s\reep"));
		
		System.out.println(Pattern.matches("s\\Seep", "s eep"));
	
		/*
		 * 해당 패턴이 적용될 문자의 개수를 정의하는 방법
		 * 
		 * 1. [ex]{n} : {}앞의 패턴이 n개 일치해야한다
		 * 2. [ex]{n,m} : {} 앞의 패턴이 최소 n개 이상 최대 m개(m포함)까지 일치해야한다
		 * 	# 정규 표현식에 {n,m}처럼 공백을 넣으면 안된다
		 * 3. [ex]{n,} : {}앞의 패턴이 최소 n개 이상 일치해야한다
		 * 4. [ex]? : 0번 또는 한번
		 * 5. [ex]+ : 최고 한번 이상
		 * 6. [ex]* : 0번 또는 여러번
		 * 
		 * */
		System.out.println(Pattern.matches("\\D{3}", "cat")); 
		System.out.println("3-5"+Pattern.matches("[\\D3-5]{5}\\.txt", "3*45!.txt")); 
		System.out.println(Pattern.matches("[\\D3-5]{2,5}\\.txt", "3!.txt")); 
		System.out.println(Pattern.matches("[가-힣]{2,}\\.txt", "안녕.txt")); 
		System.out.println(Pattern.matches("[가-힣]{2,}\\.txt", "안녕하세요.txt")); 
		System.out.println(Pattern.matches("[가-힣]{2,}\\.txt", "hi.txt")); 
		
		System.out.println(Pattern.matches(".{2,}\\.txt", "abcd.txt")); 
		
		System.out.println(Pattern.matches("[\\D3-5]{5}\\.txt", "3145!.txt")); 
	
		String regex1 = String.format(".{%d}\\.txt", 2);
		System.out.println("regex1"+Pattern.matches(regex1, "abcd.txt"));
	
		System.out.println(Pattern.matches("[가-힣]?\\.txt", ".txt")); 
		System.out.println(Pattern.matches("[가-힣]?\\.txt", "한.txt")); 
		System.out.println(Pattern.matches("[가-힣]?\\.txt", "한글.txt")); 
		
		//(-를 써도 되고 안써도되는) 전화번호 정규표현식
		System.out.println(Pattern.matches("0\\d{2}-?\\d{3,4}-?\\d{4}", "01012341234"));
		System.out.println(Pattern.matches("0\\d{2}-?\\d{3,4}-?\\d{4}", "010-1234-1234"));
		System.out.println(Pattern.matches("0\\d{2}-?\\d{3,4}-?\\d{4}", "0101231234"));
		System.out.println(Pattern.matches("0\\d{2}-?\\d{3,4}-?\\d{4}", "010-123-1234"));
		
		//연습문제 : 자바에서 허용하는 변수명을 검사할 수 있는 정규표현식을 만들어라
		System.out.println(Pattern.matches("^[a-zA-Z_$]*$", "abc")); //처음에 ^와 끝에 $는 시작과 끝을 알린다
		System.out.println(Pattern.matches("^[\\D&&\\S&&\\w$가-힣][\\w$가-힣]*$", "_김김김"));
		System.out.println(Pattern.matches("^[\\D&&\\S&&\\w$가-힣][\\w$가-힣]*g$", "_김김김g"));//끝을 g로 하겠다
		System.out.println();
		
		/*
		 * Pattern.compile(regex)
		* - 전달한 정규표현식을 해석하여 pattern인스턴스를 생성하고 반환한다
		* 
			# split() : 컴파일된 패턴 인스턴스로 split()을 진행한다
			# matcher() : Matcher 인스턴스를 생성하여 반환한다
		*/
		
		String fruit_text = "apple/banana/orange/grape/peach/mango";
		
		Pattern regex = Pattern.compile("/");
		System.out.println(regex);
		
		String[] fruits = regex.split(fruit_text);
		
		//find 다음것이 있으면 트루 없으면 펄스
		System.out.println(Arrays.toString(fruits));
		
		// 정규표현식을 해석한 뒤 생성된 인스턴스 ("어떤 문자열이든 들어오면 해석해버리겠다" 는 준비를 한 상태)
		Pattern regex2 = Pattern.compile("orange");
		
		// Matcher : 문자열을 해석한 결과, 정규표현식과 일치하는 모든 결과가 꺼내기 좋은 형태로 순서대로 저장되어 있는 객체
		Matcher matcher = regex2.matcher(fruit_text);
		
		while (matcher.find()) {
			System.out.println("찾은 것 : " + matcher.group());  //group()은 find()한 값을 꺼낸다
			System.out.println("위치 : " + matcher.start() + "부터" + matcher.end() + "까지");
		}
	}
	
	
}














