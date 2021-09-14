package ssm_study;

import java.util.regex.Pattern;

public class Regex {
	
	public static void main(String[] args) {
		System.out.println(Pattern.matches("\\[[a-zA-Z\\\',]*\\]", "['C','JAVA','Javascript','React']"));
		System.out.println("\"홍길동\"");
		System.out.println(1 != 0 ? true : false);//\"a-zA-Z,*
		//"[\"C\",\"JAVA\",\"Javascript\",\"React\"]"
	}

}
